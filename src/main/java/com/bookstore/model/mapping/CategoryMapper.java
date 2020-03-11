package com.bookstore.model.mapping;

import com.bookstore.model.dto.Category;
import com.bookstore.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {
        BookMapper.class
})
public abstract class CategoryMapper {

    @Mapping(source = "books", target = "books", ignore = true)
    public abstract Category categoryEntityToCategoryFlat(CategoryEntity categoryEntity);

}
