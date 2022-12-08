package com.user.appi.service;

import com.user.appi.dto.UserDto;
import com.user.appi.model.User;

import java.util.List;

public interface UserService {
    void addUser(UserDto user);
//    List<UserDto> getAllUsers();
    UserDto getOneById(Long id);
}
