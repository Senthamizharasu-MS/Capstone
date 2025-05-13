package com.lms.quiz_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_submission")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quizId;
    private String userId;

    @ElementCollection
    private List<UserAnswer> answers;

    @Embeddable
    @Getter @Setter
    @AllArgsConstructor @NoArgsConstructor
    public static class UserAnswer {
        private Long questionId;
        private String answer;
    }
}
