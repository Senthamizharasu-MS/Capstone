package com.lms.feedback_service.service;

import com.lms.feedback_service.dto.FeedbackDto;
import com.lms.feedback_service.model.Feedback;
import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(FeedbackDto feedbackDto);
    List<Feedback> getAllFeedback();
}