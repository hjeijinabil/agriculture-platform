package com.agriculture_platform.Notification.Controller;

import com.agriculture_platform.Notification.Entity.Notification;
import com.agriculture_platform.Notification.Service.NotificationService;
import jakarta.validation.Valid;
import org.hibernate.type.ListType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("{userId}")
    public ResponseEntity<Notification> sendNotification(@PathVariable String userId, @RequestBody String message) {
        return ResponseEntity.ok(notificationService.sendNotification(userId, message));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getNotificationsByUserId(@PathVariable String userId) {
        List<Notification> notifications = notificationService.getNotificationsByUserId(userId);
        return ResponseEntity.ok(notifications);
    }


    // WebSocket endpoint to handle notifications (optional for direct WebSocket usage)
    @MessageMapping("/sendNotification")
    @SendTo("/topic/notifications")
    public Notification sendNotificationViaWebSocket(@Valid Notification notification) {
        return notificationService.sendNotification(notification.getUserId(), notification.getMessage());
    }
}
