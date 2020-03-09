package com.bookstore.model.mapping;

import com.bookstore.model.dto.BookCover;
import com.bookstore.model.entity.BookCoverEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class BookCoverMapper {

    public abstract BookCover bookCoverEntityToBookCover(BookCoverEntity bookCoverEntity);

}
