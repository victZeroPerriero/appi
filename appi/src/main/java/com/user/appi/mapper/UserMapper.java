package com.user.appi.mapper;

import com.user.appi.dto.UserDto;
import com.user.appi.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {

    @Mapping(target = "id", source = "dto.id", ignore = true)
    @Mapping(target = "bookList", source = "dto.bookDtoList")
    User fromDtoToEntity(UserDto dto);

    @Mapping(target = "bookDtoList", source = "user.bookList")
    UserDto fromEntityToDto(User user);
    List<UserDto> fromListEntityToDto(List<User> userList);
}
