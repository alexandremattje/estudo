package com.salsatechnology.unit.service;

import com.salsatechnology.model.ProductType;
import com.salsatechnology.model.ProductTypePrice;
import com.salsatechnology.unit.service.contract.ProductTypePriceService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Service
public class ProductTypeServiceImpl implements ProductTypePriceService {

    private final Map<ProductType, ProductTypePrice> priceTable = Map.of(
            ProductType.BEACH_CHAIR, ProductTypePrice.builder().hourPrice(35.00).commission(5.00).build(),
            ProductType.BEACH_TABLE, ProductTypePrice.builder().hourPrice(25.00).commission(8.10).build(),
            ProductType.SAND_BOARD, ProductTypePrice.builder().hourPrice(25.00).commission(9.00).build(),
            ProductType.SUNSHADE, ProductTypePrice.builder().hourPrice(40.00).commission(10.30).build(),
            ProductType.SURFBOARD, ProductTypePrice.builder().hourPrice(50.00).commission(15.60).build()
    );

    @Override
    public ProductTypePrice getProductTypePrice(ProductType productType) {
        return this.priceTable.get(productType);
    }

    @Override
    public Double calculateTotal(@NotNull Integer hours, ProductTypePrice productTypePrice) {
        return hours * productTypePrice.getHourPrice();
    }

}
