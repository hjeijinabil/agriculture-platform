package com.agriculture_platform.ReviewFeedback.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserServiceClient {
    @GetMapping("/users/{username}")
    String getUserByUsername(@PathVariable("username") String username);
}
