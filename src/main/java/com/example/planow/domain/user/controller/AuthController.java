package com.example.planow.domain.user.controller;

import com.example.planow.domain.user.dto.request.SigninRequestDto;
import com.example.planow.domain.user.dto.request.SignupRequestDto;
import com.example.planow.domain.user.dto.response.AccessTokenResponseDto;
import com.example.planow.domain.user.service.AuthService;
import com.example.planow.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // signup
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid SignupRequestDto requestDto) {
        authService.signup(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Signup successful");
    }

    // login
    @PostMapping("/signin")
    public ResponseEntity<AccessTokenResponseDto> signin(@Valid @RequestBody SigninRequestDto requestDto){

        return ResponseEntity.ok(authService.signin(requestDto));
    }
}
