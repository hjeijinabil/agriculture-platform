package com.agriculture_platform.Authentication.Service;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mailler-service")
public interface MaillerService {
    @PostMapping("/mailler/send")
    String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) ;


}
