package com.lms.feedback_service.controller;

import com.lms.feedback_service.dto.FeedbackDto;
import com.lms.feedback_service.dto.FeedbackResponseDto;
import com.lms.feedback_service.model.Feedback;
import com.lms.feedback_service.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackResponseDto> createFeedback(@Valid @RequestBody FeedbackDto feedbackDto) {
        Feedback feedback = feedbackService.createFeedback(feedbackDto);
        FeedbackResponseDto responseDto = new FeedbackResponseDto(feedback.getFeedbackId(), feedback.getUserId(), feedback.getCourseId(), feedback.getComment(),feedback.getRating());
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<FeedbackResponseDto>> getAllFeedback() {
        List<Feedback> feedbackList = feedbackService.getAllFeedback();
        List<FeedbackResponseDto> responseList = feedbackList.stream()
                .map(feedback -> new FeedbackResponseDto(feedback.getFeedbackId(), feedback.getUserId(), feedback.getCourseId(), feedback.getComment(), feedback.getRating()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }
}