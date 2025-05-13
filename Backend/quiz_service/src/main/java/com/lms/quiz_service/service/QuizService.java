package com.lms.quiz_service.service;

import com.lms.quiz_service.dto.AnswerDto;
import com.lms.quiz_service.dto.QuestionRequestDto;
import com.lms.quiz_service.dto.QuizRequestDto;
import com.lms.quiz_service.dto.SubmissionDto;
import com.lms.quiz_service.model.Quiz;
import com.lms.quiz_service.model.Submission;

import java.util.List;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);
    Quiz createQuizByCategory (QuizRequestDto dto);
    List<QuestionRequestDto> getQuestionById(Long questionId);
    SubmissionDto submitQuiz(SubmissionDto SubmissionDto);
    AnswerDto getAnswersById(Long quizId, String userId);
}
