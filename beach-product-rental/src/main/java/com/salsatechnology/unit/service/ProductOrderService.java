package com.salsatechnology.unit.service;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.dto.ProductOrderListDTO;
import com.salsatechnology.model.CommissionValue;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.repository.ProductOrderRepository;
import com.salsatechnology.repository.filter.OrderFilter;
import com.salsatechnology.unit.service.contract.CommissionCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductOrderService {

	private final ProductOrderRepository productOrderRepository;

	private final CommissionCalculationService commissionCalculationService;
	
	@Transactional
	public void createOrder(ProductOrderDTO productOrderDTO) {
		productOrderRepository.save(createProductOrder(productOrderDTO));
	}

	private ProductOrder createProductOrder(ProductOrderDTO productOrderDTO) {
		ProductOrder productOrder = new ProductOrder();
		productOrder.setUserName(productOrderDTO.getUserName());
		productOrder.setProductType(productOrderDTO.getProductType());
		productOrder.setTimeHour(productOrderDTO.getTimeHour());

		CommissionValue finalTotal = this.commissionCalculationService.calculate(productOrderDTO.getTimeHour(), productOrderDTO.getProductType());

		productOrder.setProductValue((long) (finalTotal.getProductValue() * 100));
		productOrder.setProductTotal((long) (finalTotal.getProductTotal() * 100));
		productOrder.setUserAmount((long) (finalTotal.getUserAmount() * 100));
		return productOrder;
	}

	public Page<ProductOrderListDTO> getOrders(OrderFilter filter) {
		Pageable pageable = Pageable.ofSize(filter.getOffSet()).withPage(filter.getPage());
		Page<ProductOrder> page = this.productOrderRepository.findAll(ProductOrderRepository.filterBy(filter), pageable);
		
		return new PageImpl<>(page.stream().map(this::mapToDto).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	private ProductOrderListDTO mapToDto(ProductOrder jpa) {
		return ProductOrderListDTO.builder()
				.id(jpa.getId())
				.productType(jpa.getProductType())
				.timeHour(jpa.getTimeHour())
				.productTotal((double) (jpa.getProductTotal() / 100))
				.productValue((double) jpa.getProductValue() / 100)
				.userName(jpa.getUserName())
				.userAmount((double) jpa.getUserAmount() / 100)
				.build();
	}

}
