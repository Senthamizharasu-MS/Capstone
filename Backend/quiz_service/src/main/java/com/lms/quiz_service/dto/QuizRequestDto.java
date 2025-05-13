package com.lms.quiz_service.dto;

import java.util.Map;

public record QuizRequestDto(String title, Map<String,Integer> category) {
}
