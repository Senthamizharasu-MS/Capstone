package com.lms.feedback_service.controller;

import com.lms.feedback_service.dto.FeedbackDto;
import com.lms.feedback_service.model.Feedback;
import com.lms.feedback_service.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody FeedbackDto feedbackDto) {
        Feedback feedback = feedbackService.createFeedback(feedbackDto);
        return ResponseEntity.ok(feedback);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbackList = feedbackService.getAllFeedback();
        return ResponseEntity.ok(feedbackList);
    }
}