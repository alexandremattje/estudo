package com.salsatechnology.unit.service.contract;

import com.salsatechnology.model.CommissionValue;
import com.salsatechnology.model.ProductType;

import javax.validation.constraints.NotNull;

public interface CommissionCalculationService {

    CommissionValue calculate (@NotNull Integer hours, ProductType productType);

}
