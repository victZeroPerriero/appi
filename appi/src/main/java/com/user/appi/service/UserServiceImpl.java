package com.user.appi.service;

import com.user.appi.dto.UserDto;
import com.user.appi.mapper.UserMapper;
import com.user.appi.model.User;
import com.user.appi.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    @PersistenceContext
    private final EntityManager em;

    @Override
    public void addUser(UserDto dto) {
       User user = userMapper.fromDtoToEntity(dto);
        userRepo.save(user);
    }

    @Override
    public UserDto getOneById(Long id) {
       User user = userRepo.findById(id).orElse(null);
        return userMapper.fromEntityToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        Query query = em.createNativeQuery("select * from users", User.class);
        List<User> users = query.getResultList();
        return userMapper.fromListEntityToDto(users);
    }

//    @Override
//    public List<UserDto> getAllUsers() {
//        return  userMapper.fromListEntityToDto( userRepo.findAll());
//    }
}
