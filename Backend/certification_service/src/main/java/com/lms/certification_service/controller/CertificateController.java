package com.lms.certification_service.controller;

import com.lms.certification_service.dto.CertificateDto;
import com.lms.certification_service.dto.CertificateRequestDto;
import com.lms.certification_service.service.CertificateServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    @Autowired
    private CertificateServiceImp certificateService;

    @PostMapping
    public ResponseEntity<CertificateDto> createCertificate(@Valid @RequestBody CertificateDto dto) {
       CertificateDto create = certificateService.createCertificate(dto);
        return ResponseEntity.ok(create);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CertificateRequestDto>> getCertificateByUserId(@PathVariable String userId) {
        List<CertificateRequestDto> Dto = certificateService.getCertificateByUserId(userId);
        return ResponseEntity.ok().body(Dto);
    }
}
