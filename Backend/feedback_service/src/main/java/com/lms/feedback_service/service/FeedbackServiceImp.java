package com.lms.feedback_service.service;

import com.lms.feedback_service.dto.FeedbackDto;
import com.lms.feedback_service.model.Feedback;
import com.lms.feedback_service.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackServiceImp implements FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    @Override
    public Feedback createFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setUserId(feedbackDto.userId());
        feedback.setMessage(feedbackDto.message());
        return feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();
    }
}