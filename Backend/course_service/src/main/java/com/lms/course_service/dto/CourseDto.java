package com.lms.course_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CourseDto(
        Long id,
        @NotBlank(message = "Course name is required") String courseName,
        @NotBlank(message = "Course code is required") String courseCode,
        String description,
        @NotNull(message = "Starting date is required") LocalDate startingDate,
        @NotNull(message = "Ending date is required") LocalDate endingDate) {
}