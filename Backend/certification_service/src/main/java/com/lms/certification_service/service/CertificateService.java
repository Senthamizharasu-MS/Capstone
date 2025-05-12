package com.lms.certification_service.service;

import com.lms.certification_service.dto.CertificateDto;
import com.lms.certification_service.dto.CertificateRequestDto;

import java.util.List;

public interface CertificateService {
    CertificateDto createCertificate(CertificateDto dto);
    List<CertificateRequestDto> getCertificateByUserId(String userId);
}
