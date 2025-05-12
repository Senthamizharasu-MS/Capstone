package com.lms.certification_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CertificateDto(
        @NotBlank(message = "User ID cannot be empty") String userId,

        @NotBlank(message = "User Name cannot be empty") String userName,

        @NotBlank(message = "Course ID cannot be empty") String courseId,

        @NotBlank(message = "Course Name cannot be empty")String courseName,

        @NotNull(message = "Issue Date cannot be empty") LocalDate issueDate,

        @NotNull(message = "Expiry Date cannot be empty") LocalDate expiryDate

) { }
