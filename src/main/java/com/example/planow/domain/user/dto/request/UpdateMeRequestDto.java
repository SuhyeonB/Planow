package com.example.planow.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateMeRequestDto {

    @NotBlank(message = "nickname must not be blank")
    private String nickname;
}
