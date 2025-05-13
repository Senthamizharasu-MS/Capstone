package com.lms.quiz_service.dto;

import com.lms.quiz_service.model.Submission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SubmissionDto(
        @NotNull(message = "Quiz Id cannot be null") Long quizId,
        @NotBlank(message = "User Id cannot be empty.") String userId,
        @NotEmpty(message = "Answer cannot be empty.") List<Submission.UserAnswer> answers
) { }
