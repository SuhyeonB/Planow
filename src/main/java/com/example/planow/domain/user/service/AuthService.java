package com.example.planow.domain.user.service;

import com.example.planow.domain.user.dto.request.SigninRequestDto;
import com.example.planow.domain.user.dto.request.SignupRequestDto;
import com.example.planow.domain.user.dto.response.AccessTokenResponseDto;
import com.example.planow.domain.user.entity.User;
import com.example.planow.domain.user.repository.UserRepository;
import com.example.planow.global.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public void signup(SignupRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use.");
        }

        String encoded = passwordEncoder.encode(requestDto.getPassword());

        User user = User.builder()
                .email(requestDto.getEmail())
                .password(encoded)
                .nickname(requestDto.getNickname())
                .build();

        userRepository.save(user);
    }

    @Transactional
    public AccessTokenResponseDto signin(SigninRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        String token =  jwtUtil.createToken(user.getId(), user.getEmail(), user.getUserRole());

        return new AccessTokenResponseDto(token);
    }
}