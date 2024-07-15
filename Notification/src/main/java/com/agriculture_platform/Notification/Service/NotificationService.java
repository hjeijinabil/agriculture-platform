package com.agriculture_platform.Notification.Service;

import com.agriculture_platform.Notification.Entity.Notification;
import com.agriculture_platform.Notification.Repository.NotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Transactional
    public Notification sendNotification(String userId, String message) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setTimestamp(LocalDateTime.now());
        notificationRepository.save(notification);

        // Send notification to WebSocket topic
        messagingTemplate.convertAndSendToUser(userId, "/queue/notifications", notification);

        return notification;
    }

    @Transactional()
    public List<Notification> getNotificationsByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }
}
