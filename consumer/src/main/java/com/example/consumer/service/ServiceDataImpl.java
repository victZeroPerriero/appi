package com.example.consumer.service;

import com.example.consumer.dto.UserDto;
import com.example.consumer.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceDataImpl implements ServiceData {
    private final UserRepo userRepo;
    @Override
    public UserDto save(UserDto dto) {
        return userRepo.save(dto);
    }
}
