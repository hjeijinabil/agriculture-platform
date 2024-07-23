package com.agriculture_platform.ReviewFeedback.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "Consultation-management")
public interface ConsultationService {
    @GetMapping("/consultation/{consultationId}")
    String getByIdConsultation(@PathVariable("consultationId") String consultationId);

}