package com.user.appi.mapper;

import com.user.appi.dto.BookDto;
import com.user.appi.model.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD, uses = {BookMapper.class})
public interface BookMapper {
    @Mapping(target = "id", source = "dto.id", ignore = true)
    Book fromDtoToEntity(BookDto dto);

    BookDto fromEntityToDto(Book book);
    List<BookDto> fromListEntityToDto(List<Book> book);
}
