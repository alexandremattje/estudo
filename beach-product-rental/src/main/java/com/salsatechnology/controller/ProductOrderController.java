package com.salsatechnology.controller;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.dto.ProductOrderListDTO;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.repository.filter.OrderFilter;
import com.salsatechnology.unit.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService productOrderService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody @Valid ProductOrderDTO productOrderDTO) {
		productOrderService.createOrder(productOrderDTO);
	}

	@GetMapping("/list")
	public ResponseEntity<Page<ProductOrderListDTO>> getOrders(
			@RequestParam ProductType productType,
			@RequestParam int page,
			@RequestParam int offSet) {
		return ResponseEntity.ok(this.productOrderService.getOrders(OrderFilter.builder()
				.offSet(offSet)
				.page(page)
				.productType(productType)
				.build()));
	}
}
