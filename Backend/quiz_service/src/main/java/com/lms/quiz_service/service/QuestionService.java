package com.lms.quiz_service.service;

import com.lms.quiz_service.model.Question;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface QuestionService {
    public List<Question> getAllQuestions();
//    public List<Question> getQuestionByCategory(String category);
    public List<String> getAllCategories();
    void saveQuestionsFromFile(MultipartFile file) throws IOException;
}
