package com.salsatechnology.unit.service.contract;

import com.salsatechnology.model.ProductType;
import com.salsatechnology.model.ProductTypePrice;

import javax.validation.constraints.NotNull;

public interface ProductTypePriceService {

    ProductTypePrice getProductTypePrice(ProductType productType);

    Double calculateTotal(@NotNull Integer hours, ProductTypePrice productTypePrice);

}
