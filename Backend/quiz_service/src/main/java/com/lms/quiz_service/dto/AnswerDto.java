package com.lms.quiz_service.dto;

import java.util.List;

public record AnswerDto(
        Long quizId,
        String userName,
        List<UserAnswer> answers
) {
    public record UserAnswer(Long questionId, String answer, String rightAnswer) {}
}