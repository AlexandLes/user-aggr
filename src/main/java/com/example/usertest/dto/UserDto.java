package com.example.usertest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User DTO representation")
public record UserDto(
        @Schema(description = "User unique ID") String id,
        @Schema(description = "User login/username") String username,
        @Schema(description = "First name") String name,
        @Schema(description = "Last name") String surname
) {}