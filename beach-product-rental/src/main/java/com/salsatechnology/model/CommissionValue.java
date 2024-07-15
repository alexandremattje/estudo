package com.salsatechnology.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class CommissionValue {

	private Double productValue;
	private Double productTotal;
	private Double userAmount;

}
