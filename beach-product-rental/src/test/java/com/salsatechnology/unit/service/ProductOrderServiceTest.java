package com.salsatechnology.unit.service;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.model.CommissionValue;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.repository.ProductOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ProductOrderServiceTest {

    @InjectMocks
    private ProductOrderService productOrderService;

    @Captor
    ArgumentCaptor<ProductOrder> productOrderArgumentCaptor;

    @Mock
    private ProductOrderRepository productOrderRepository;

    @Mock
    private CommissionCalculationServiceImpl commissionCalculationService;

    @Test
    public void createAProductOrderAndCheckIntegerValuesTest() {
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setProductType(ProductType.BEACH_CHAIR);
        productOrderDTO.setUserName("user_test");
        productOrderDTO.setTimeHour(2);

        doReturn(null).when(this.productOrderRepository).save(any());
        doReturn(CommissionValue.builder()
                .productValue(123.45)
                .productTotal(1234.56)
                .userAmount(21.43)
                .build()).when(this.commissionCalculationService).calculate(
                productOrderDTO.getTimeHour(), productOrderDTO.getProductType());

        this.productOrderService.createOrder(productOrderDTO);
        verify(this.productOrderRepository).save(this.productOrderArgumentCaptor.capture());

        ProductOrder capturedValue = productOrderArgumentCaptor.getValue();
        Assertions.assertEquals(capturedValue.getProductValue(), 12345);
        Assertions.assertEquals(capturedValue.getProductTotal(), 123456);
        Assertions.assertEquals(capturedValue.getUserAmount(), 2143);

    }

}
