package com.example.planow.domain.user.dto.response;

import com.example.planow.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponseDto {
    private final Long id;
    private final String email;
    private final String nickname;
    private final LocalDateTime createdAt;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.createdAt = user.getCreatedAt();
    }
}
