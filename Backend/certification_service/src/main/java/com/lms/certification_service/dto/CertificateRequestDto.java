package com.lms.certification_service.dto;

import java.time.LocalDate;

public record CertificateRequestDto(String certificateId, String userId,
                                    String userName, String courseName,
                                    LocalDate issueDate, LocalDate expiryDate
){ }
