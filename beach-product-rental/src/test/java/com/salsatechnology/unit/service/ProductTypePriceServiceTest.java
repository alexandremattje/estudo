package com.salsatechnology.unit.service;

import com.salsatechnology.model.ProductType;
import com.salsatechnology.model.ProductTypePrice;
import com.salsatechnology.unit.service.contract.ProductTypePriceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTypePriceServiceTest {

    @Autowired
    private ProductTypePriceService productTypePriceService;

    @Test
    public void checkPriceTableIsEqualToReadmeValuesTest() {
        Assertions.assertEquals(this.productTypePriceService.getProductTypePrice(ProductType.BEACH_CHAIR),
                ProductTypePrice.builder().hourPrice(35.00).commission(5.00).build());
        Assertions.assertEquals(this.productTypePriceService.getProductTypePrice(ProductType.BEACH_TABLE),
                ProductTypePrice.builder().hourPrice(25.00).commission(8.10).build());
        Assertions.assertEquals(this.productTypePriceService.getProductTypePrice(ProductType.SAND_BOARD),
                ProductTypePrice.builder().hourPrice(25.00).commission(9.00).build());
        Assertions.assertEquals(this.productTypePriceService.getProductTypePrice(ProductType.SUNSHADE),
                ProductTypePrice.builder().hourPrice(40.00).commission(10.30).build());
        Assertions.assertEquals(this.productTypePriceService.getProductTypePrice(ProductType.SURFBOARD),
                ProductTypePrice.builder().hourPrice(50.00).commission(15.60).build());
    }

    @Test
    public void totalCalculateTest() {
        Assertions.assertEquals(
                this.productTypePriceService.calculateTotal(1,
                        ProductTypePrice.builder().hourPrice(100.00).commission(10.00).build()), 100.00);
    }

}
