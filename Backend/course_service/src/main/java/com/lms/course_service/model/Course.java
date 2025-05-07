package com.lms.course_service.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String courseCode;
    private String description;
    private String courseCategory;
    private String courseContent;
    private LocalDate startingDate;
    private LocalDate endingDate;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    public enum CourseStatus{
        ACTIVE,
        INACTIVE,
        COMPLETED
    }
}
