package com.bookstore.model.mapping;

import com.bookstore.model.dto.Customer;
import com.bookstore.model.entity.CustomerEntity;
import com.bookstore.web.ui.form.BillingForm;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CustomerMapper {

    public abstract CustomerEntity toCustomerEntity(BillingForm billingForm);

    public abstract Customer toCustomer(CustomerEntity customerEntity);

}
