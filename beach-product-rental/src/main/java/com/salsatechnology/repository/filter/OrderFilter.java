package com.salsatechnology.repository.filter;

import com.salsatechnology.model.ProductType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderFilter {

    private int page;
    private int offSet;

    private ProductType productType;

}
