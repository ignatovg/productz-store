package com.productz.productzstore.service.impl;

import com.productz.productzstore.exception.ServiceException;
import com.productz.productzstore.exception.user.ErrorCode;
import com.productz.productzstore.exception.user.UserNotFoundException;
import com.productz.productzstore.model.User;
import com.productz.productzstore.model.dto.request.UserRequestDto;
import com.productz.productzstore.model.dto.response.UserResponseDto;
import com.productz.productzstore.repository.UserRepository;
import com.productz.productzstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponseDto saveUser(UserRequestDto user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new ServiceException(ErrorCode.USERNAME_ALREADY_TAKEN);
        }
        return new UserResponseDto(userRepository.save(new User(user.getUsername(), user.getPassword())));
    }

    @Override
    @Transactional
    public UserResponseDto changePassword(UserRequestDto user) {
        User currentUser = getUserByUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());

        return new UserResponseDto(userRepository.save(currentUser));
    }

    @Override
    @Transactional
    public void deleteUser(UUID userId) {
        if (!userRepository.existsById(userId)) {
            throw new ServiceException(ErrorCode.USER_NOT_FOUND);
        }
        userRepository.deleteById(userId);
    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND, username));
    }
}
