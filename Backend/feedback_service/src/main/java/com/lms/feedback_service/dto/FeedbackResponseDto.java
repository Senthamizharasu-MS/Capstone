package com.lms.feedback_service.dto;

public record FeedbackResponseDto(Long id, String userId, String courseId, String comment, Integer rating) {
}