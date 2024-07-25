package com.agriculture_platform.Consulation.Management.Service;

import com.agriculture_platform.Consulation.Management.Dto.NotificationDto;
import com.agriculture_platform.Consulation.Management.request.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import javax.management.Notification;

@FeignClient(name = "notification-service")
public interface NotificationServiceClient {
    @PostMapping("/notifications")
    NotificationDto createNotification(NotificationRequest notificationRequest);
}
