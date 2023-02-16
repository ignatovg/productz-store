package com.productz.productzstore.service;

import com.productz.productzstore.model.dto.request.UserRequestDto;
import com.productz.productzstore.model.dto.response.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserResponseDto> getAllUsers();

    UserResponseDto saveUser(UserRequestDto user);

    UserResponseDto changePassword(UserRequestDto user);

    void deleteUser(UUID userId);
}
