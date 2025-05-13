package com.lms.quiz_service.controller;

import com.lms.quiz_service.dto.AnswerDto;
import com.lms.quiz_service.dto.QuestionRequestDto;
import com.lms.quiz_service.dto.QuizRequestDto;
import com.lms.quiz_service.dto.SubmissionDto;
import com.lms.quiz_service.model.Quiz;
import com.lms.quiz_service.model.Submission;
import com.lms.quiz_service.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;



    @PostMapping
    public ResponseEntity<Quiz> createQuizByCategory(@RequestBody QuizRequestDto dto) {
        Quiz savedQuiz = quizService.createQuizByCategory(dto);
        return ResponseEntity.ok().body(savedQuiz);
    }

    @GetMapping("/{questionId}/questions")
    public ResponseEntity<List<QuestionRequestDto>> getQuestionsByQuizId(@PathVariable Long questionId) {
        List<QuestionRequestDto> questions = quizService.getQuestionById(questionId);
        if (questions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(questions);
    }

    @PostMapping("/submit")
    public ResponseEntity<SubmissionDto> submitQuiz (@Valid @RequestBody SubmissionDto dto){
        SubmissionDto submission = quizService.submitQuiz(dto);
        return ResponseEntity.ok().body(submission);
    }

    @GetMapping("/answers")
    public ResponseEntity<AnswerDto> getAnswersById (@RequestParam Long quizId, String userId){
        System.out.println(quizId + userId);
        AnswerDto answerDto = quizService.getAnswersById(quizId, userId);
        return ResponseEntity.ok().body(answerDto);
    }
}
