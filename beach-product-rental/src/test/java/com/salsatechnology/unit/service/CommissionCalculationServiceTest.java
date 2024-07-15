package com.salsatechnology.unit.service;

import com.salsatechnology.model.CommissionValue;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.model.ProductTypePrice;
import com.salsatechnology.unit.service.contract.ProductTypePriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class CommissionCalculationServiceTest {

    @InjectMocks
    private CommissionCalculationServiceImpl commissionCalculationService;

    @Mock
    private ProductTypePriceService productTypePriceService;

    @Test
    public void commissionValueCalculationTest() {
        ProductType product = ProductType.SUNSHADE;
        ProductTypePrice productTypePrice = ProductTypePrice.builder()
                .commission(10.00)
                .hourPrice(100.00)
                .build();
        Integer hours = 2;
        doReturn(productTypePrice).when(productTypePriceService).getProductTypePrice(product);
        doReturn(200.00).when(productTypePriceService).calculateTotal(hours, productTypePrice);

        verify(productTypePriceService, atMostOnce()).getProductTypePrice(product);
        verify(productTypePriceService, atMostOnce()).calculateTotal(hours, productTypePrice);
        Assertions.assertEquals(
                this.commissionCalculationService.calculate(hours, product),
                CommissionValue.builder()
                        .productValue(100.00)
                        .userAmount(20.00)
                        .productTotal(200.00)
                        .build());
    }

}
