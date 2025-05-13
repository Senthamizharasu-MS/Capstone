package com.lms.quiz_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
@Table(name = "quiz")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Question> questionList;
}
