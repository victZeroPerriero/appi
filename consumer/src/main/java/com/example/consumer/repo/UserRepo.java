package com.example.consumer.repo;

import com.example.consumer.dto.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserDto,Long> {
}
