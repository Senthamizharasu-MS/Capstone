package com.lms.quiz_service.repo;

import com.lms.quiz_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
//    List<Question> findByCategory(String category);

    @Query("SELECT DISTINCT q.category FROM Question q")
    List<String> findDistinctCategories();

    @Query(value = "SELECT * FROM Question WHERE category = :category ORDER BY RAND() LIMIT :numberOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numberOfQuestions") int numberOfQuestions);

    String findRightAnswerByQuestionId(Long questionId);
}
