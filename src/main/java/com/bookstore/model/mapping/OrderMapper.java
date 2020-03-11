package com.bookstore.model.mapping;

import com.bookstore.model.dto.Order;
import com.bookstore.model.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class OrderMapper {

    @Mapping(source = "customer.id", target = "customerId")
    public abstract Order orderEntityToOrder(OrderEntity orderEntity);

}
