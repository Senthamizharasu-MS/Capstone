package com.lms.course_service.dto;

import java.time.LocalDate;

public record CourseResponseDto(
        Long id,
        String courseName,
        String courseCode,
        String description,
        LocalDate startingDate,
        LocalDate endingDate) {
}