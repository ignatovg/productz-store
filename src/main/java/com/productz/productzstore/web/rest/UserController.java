package com.productz.productzstore.web.rest;

import com.productz.productzstore.model.dto.request.UserRequestDto;
import com.productz.productzstore.model.dto.response.UserResponseDto;
import com.productz.productzstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/create")
    public UserResponseDto createUser(@RequestBody UserRequestDto user, HttpServletResponse response) {
        response.setStatus(HttpStatus.CREATED.value());
        return userService.saveUser(user);
    }

    @PostMapping("/update")
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.changePassword(user));
    }

    @DeleteMapping("/delete/{userId}")
    private void deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
    }

}
