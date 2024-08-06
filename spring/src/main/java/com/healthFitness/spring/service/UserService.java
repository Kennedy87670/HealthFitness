package com.healthFitness.spring.service;

import com.healthFitness.spring.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId, UserDto userDTO);
    void deleteUser(Long userId);
}
