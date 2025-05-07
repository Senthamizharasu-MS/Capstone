package com.lms.feedback_service.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record FeedbackDto(
        @NotBlank(message = "User ID is required") String userId,
        @NotBlank(message = "Course ID is required") String courseId,
        @NotBlank(message = "Message is required") String comment,
        @Min(value = 0,message = "Invalid rating") @Max(value = 5,message = "Invalid rating") Integer rating) {
}
