package com.user.appi.mapper;

import com.user.appi.dto.BookDto;
import com.user.appi.model.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD, uses = {BookMapper.class})
public interface LibraryJournalMapper {

    @Mapping(target = "id", source = "bookDto.id", ignore = true)
    Book fromDtoToEntity(BookDto bookDto);
    @Mapping(target = "id", source = "book.id")
    BookDto fromEntityToDto(Book book);
}
