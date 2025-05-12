package com.lms.certification_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Entity
@Table(name = "certificate")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Certificate {

    @Id
    private String certificateId;

    private String userId;
    private String userName;
    private String courseCode;
    private String courseName;
    private LocalDate issueDate;
    private LocalDate expiryDate;


    @PrePersist
    public void generateCertificateId() {
        this.certificateId = "CERT-" + System.currentTimeMillis() + "-" + new Random().nextInt(1000);
    }
}