package com.salsatechnology.dto;

import com.salsatechnology.model.ProductType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductOrderListDTO {

	private Long id;

	private String userName;

	private ProductType productType;

	private Integer timeHour;

	private Double userAmount;

	private Double productTotal;

	private Double productValue;
}
