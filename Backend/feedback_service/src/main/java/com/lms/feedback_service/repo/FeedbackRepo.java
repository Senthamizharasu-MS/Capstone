package com.lms.feedback_service.repo;

import com.lms.feedback_service.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
}