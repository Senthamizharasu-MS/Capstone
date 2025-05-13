package com.lms.quiz_service.repo;

import com.lms.quiz_service.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubmissionRepo extends JpaRepository<Submission,Long> {

    @Query("SELECT s FROM Submission s WHERE s.quizId = :quizId AND s.userId = :userId")
    Submission findByQuizIdAndUserId(@Param("quizId") Long quizId, @Param("userId") String userId);
//    Submission findByQuizIdAndUserId(Long quizId, String userId);
}
