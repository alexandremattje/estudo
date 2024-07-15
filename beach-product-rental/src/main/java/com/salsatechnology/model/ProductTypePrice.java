package com.salsatechnology.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class ProductTypePrice {

	private Double hourPrice;
	private Double commission;

}
