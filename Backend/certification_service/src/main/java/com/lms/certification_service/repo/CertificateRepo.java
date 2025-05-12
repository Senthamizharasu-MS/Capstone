package com.lms.certification_service.repo;

import com.lms.certification_service.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepo extends JpaRepository<Certificate,String> {
    List<Certificate> findByUserId(String userId);
}
