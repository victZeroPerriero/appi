package com.user.appi.controller;


import com.user.appi.dto.UserDto;
import com.user.appi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public UserDto getOneDto(@PathVariable("id") Long id){
        return userService.getOneById(id);
    }
    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public void add(@RequestBody UserDto dto){
        userService.addUser(dto);
    }

}
