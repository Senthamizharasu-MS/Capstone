package com.lms.course_service.dto;

import com.lms.course_service.model.Course;

import java.time.LocalDate;

public record CourseResponseDto(
        Long id,
        String courseName,
        String courseCode,
        String description,
        String courseCategory,
        String courseContent,
        LocalDate startingDate,
        LocalDate endingDate,
        String status) {
}