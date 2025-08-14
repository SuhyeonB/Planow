package com.example.planow.domain.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequestDto {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 12, message = "Password must be 8 to 12 characters long.")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,12}$",
            message = "Password must contain both letters and numbers."
    )
    private String password;

    @NotBlank
    private String nickname;
}
