package com.lms.certification_service.service;

import com.lms.certification_service.dto.CertificateDto;
import com.lms.certification_service.dto.CertificateRequestDto;
import com.lms.certification_service.model.Certificate;
import com.lms.certification_service.repo.CertificateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CertificateServiceImp implements CertificateService{

    @Autowired
    private CertificateRepo certificateRepo;

    @Override
    public CertificateDto createCertificate (CertificateDto dto) {
        Certificate certificate = mapToEntity(dto);
        Certificate saveCertificate = certificateRepo.save(certificate);
        return mapToDto(saveCertificate);
    }

    @Override
    public List<CertificateRequestDto> getCertificateByUserId(String userId) {
        return certificateRepo.findByUserId(userId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CertificateRequestDto convertToDto(Certificate certificate) {
        return new CertificateRequestDto(
                certificate.getCertificateId(),
                certificate.getUserId(),
                certificate.getUserName(),
                certificate.getCourseName(),
                certificate.getIssueDate(),
                certificate.getExpiryDate()
        );
    }


    private CertificateDto mapToDto(Certificate certificate) {
        return new CertificateDto(
                certificate.getUserId(),
                certificate.getUserName(),
                certificate.getCourseCode(),
                certificate.getCourseName(),
                certificate.getIssueDate(),
                certificate.getExpiryDate());
    }

    private Certificate mapToEntity(CertificateDto dto) {
        Certificate c = new Certificate();
        c.setUserId(dto.userId());
        c.setUserName(dto.userName());
        c.setCourseCode(dto.courseId());
        c.setCourseName(dto.courseName());
        c.setIssueDate(dto.issueDate());
        c.setExpiryDate(dto.expiryDate());
        return c;
    }
}
