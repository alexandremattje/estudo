package com.salsatechnology.unit.service;

import com.salsatechnology.model.CommissionValue;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.model.ProductTypePrice;
import com.salsatechnology.unit.service.contract.CommissionCalculationService;
import com.salsatechnology.unit.service.contract.ProductTypePriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommissionCalculationServiceImpl implements CommissionCalculationService {

    private final ProductTypePriceService productTypePriceService;

    @Override
    public CommissionValue calculate(@NotNull Integer hours, ProductType productType) {
        ProductTypePrice price = this.productTypePriceService.getProductTypePrice(productType);
        Double total = this.productTypePriceService.calculateTotal(hours, price);
        return CommissionValue.builder()
                .productTotal(total)
                .productValue(price.getHourPrice())
                .userAmount((total * price.getCommission()) / 100)
                .build();
    }

}
