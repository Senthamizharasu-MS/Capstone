package com.lms.feedback_service.dto;

import jakarta.validation.constraints.NotBlank;

public record FeedbackDto(
        @NotBlank(message = "User ID is required") String userId,
        @NotBlank(message = "Message is required") String message) {
}