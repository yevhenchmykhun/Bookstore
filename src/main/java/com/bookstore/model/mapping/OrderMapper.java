package com.bookstore.model.mapping;

import com.bookstore.model.dto.Order;
import com.bookstore.model.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {
        CustomerMapper.class
})
public abstract class OrderMapper {

    public abstract Order orderEntityToOrder(OrderEntity orderEntity);

}
