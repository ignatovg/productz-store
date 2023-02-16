package com.productz.productzstore.model.dto.response;

import com.productz.productzstore.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private UUID id;
    private String username;

    public UserResponseDto(User user) {
        setId(user.getId());
        setUsername(user.getUsername());
    }
}
