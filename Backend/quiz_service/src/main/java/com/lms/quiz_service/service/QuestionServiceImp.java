package com.lms.quiz_service.service;

import com.lms.quiz_service.model.Question;
import com.lms.quiz_service.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService{

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    @Override
    public List<String> getAllCategories(){ return questionRepo.findDistinctCategories(); }

    @Override
    public void saveQuestionsFromFile(MultipartFile file) throws IOException {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    questions.add(getQuestion(data));
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            throw e;
        }

        if (!questions.isEmpty()) {
            questionRepo.saveAll(questions);
        }
    }

    private static Question getQuestion(String[] data) {
        Question question = new Question();
        question.setCategory(data[0]);
        question.setDifficultyLevel(data[1]);
        question.setQuestionTitle(data[2]);
        List<String> opt = new ArrayList<>();
        opt.add(data[3]);
        opt.add(data[4]);
        opt.add(data[5]);
        opt.add(data[6]);
        question.setOptions(opt);
        question.setRightAnswer(data[7]);
        return question;
    }
}
