package com.salsatechnology.integration.service;

import com.salsatechnology.dto.ProductOrderListDTO;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.repository.filter.OrderFilter;
import com.salsatechnology.unit.service.ProductOrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.jdbc.Sql;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ProductOrderServiceTest {

    @Autowired
    private ProductOrderService productOrderService;

    @Test
    @Sql(scripts = {"/scripts/orders.sql"})
    @Sql(scripts = {"/scripts/delete_orders.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void getOrdersFilteredTest() {
        Page<ProductOrderListDTO> list = this.productOrderService.getOrders(OrderFilter.builder()
                .productType(ProductType.SURFBOARD)
                .page(0)
                .offSet(3)
                .build());
        Assertions.assertEquals(4, list.getTotalElements());
        Assertions.assertEquals(2, list.getTotalPages());
    }

    @Test
    @Sql(scripts = {"/scripts/orders.sql"})
    @Sql(scripts = {"/scripts/delete_orders.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void getOrdersFilteredEmptyListTest() {
        Page<ProductOrderListDTO> list = this.productOrderService.getOrders(OrderFilter.builder()
                .productType(ProductType.SAND_BOARD)
                .page(0)
                .offSet(3)
                .build());
        Assertions.assertEquals(0, list.getTotalElements());
        Assertions.assertEquals(0, list.getTotalPages());
    }

}
