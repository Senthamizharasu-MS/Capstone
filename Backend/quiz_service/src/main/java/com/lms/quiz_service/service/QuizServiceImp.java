package com.lms.quiz_service.service;

import com.lms.quiz_service.dto.AnswerDto;
import com.lms.quiz_service.dto.QuestionRequestDto;
import com.lms.quiz_service.dto.QuizRequestDto;
import com.lms.quiz_service.dto.SubmissionDto;
import com.lms.quiz_service.model.Question;
import com.lms.quiz_service.model.Quiz;
import com.lms.quiz_service.model.Submission;
import com.lms.quiz_service.repo.QuestionRepo;
import com.lms.quiz_service.repo.QuizRepo;
import com.lms.quiz_service.repo.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuizServiceImp implements QuizService {

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    SubmissionRepo submissionRepo;
    @Autowired
    QuestionRepo questionRepo;


    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz createQuizByCategory(QuizRequestDto dto) {
        List<Question> allQuestions = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : dto.category().entrySet()) {
            String category = entry.getKey();
            int numberOfQuestions = entry.getValue();

            List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numberOfQuestions);
            allQuestions.addAll(questions);
        }
        Quiz combinedQuiz = new Quiz();
        combinedQuiz.setTitle(dto.title());
        combinedQuiz.setQuestionList(allQuestions);
        return createQuiz(combinedQuiz);
    }


    @Override
    public List<QuestionRequestDto> getQuestionById(Long quizId) {
        return quizRepo.findById(quizId)
                .map(quiz -> quiz.getQuestionList().stream()
                        .map(q -> new QuestionRequestDto(q.getQuestionId(), q.getQuestionTitle(), q.getOptions()))
                        .collect(Collectors.toList()))
                .orElseGet(List::of);
    }

    @Override
    public SubmissionDto submitQuiz(SubmissionDto dto) {
        Submission submission = mapToEntity(dto);
        return mapToDto(submissionRepo.save(submission)) ;
    }

    @Override
    public AnswerDto getAnswersById(Long quizId, String userId) {

        Submission submission = submissionRepo.findByQuizIdAndUserId(quizId, userId);

        List<Submission.UserAnswer> userAnswers = submission.getAnswers();

        List<AnswerDto.UserAnswer> updatedUserAnswers = new ArrayList<>();
        for (Submission.UserAnswer userAnswer : userAnswers) {
            Question question = questionRepo.findById(userAnswer.getQuestionId()).orElse(null);
            String rightAnswer = (question != null) ? question.getRightAnswer() : null;
            updatedUserAnswers.add(new AnswerDto.UserAnswer(userAnswer.getQuestionId(), userAnswer.getAnswer(), rightAnswer));
        }
        return new AnswerDto(quizId, userId, updatedUserAnswers);
    }



    private Submission mapToEntity(SubmissionDto dto) {
        Submission s = new Submission();
        s.setQuizId(dto.quizId());
        s.setUserId(dto.userId());
        s.setAnswers(dto.answers());
        return s;
    }

    private SubmissionDto mapToDto(Submission submission){
        return new SubmissionDto(
                submission.getQuizId(),
                submission.getUserId(),
                submission.getAnswers()
        );
    }

}
