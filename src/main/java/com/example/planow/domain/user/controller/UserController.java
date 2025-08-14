package com.example.planow.domain.user.controller;

import com.example.planow.domain.user.dto.request.UpdateMeRequestDto;
import com.example.planow.domain.user.dto.response.UserResponseDto;
import com.example.planow.domain.user.service.UserService;
import com.example.planow.global.dto.AuthUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    // get me
    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getMe(@AuthenticationPrincipal AuthUser authUser) {
        return ResponseEntity.ok(userService.getMe(authUser.getUserId()));
    }

    // put me
    @PutMapping("/me")
    public ResponseEntity<UserResponseDto> updateMe(
            @AuthenticationPrincipal AuthUser authUser,
            @Valid @RequestBody UpdateMeRequestDto requestDto
            ) {
        return ResponseEntity.ok(userService.updateMe(authUser.getUserId(), requestDto));
    }

    // delete me
    @DeleteMapping("/me")
    public ResponseEntity<Void> deleteMe(@AuthenticationPrincipal AuthUser authUser) {
        userService.deleteMe(authUser.getUserId());
        return ResponseEntity.noContent().build();
    }
}
