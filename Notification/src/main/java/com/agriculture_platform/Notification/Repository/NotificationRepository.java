package com.agriculture_platform.Notification.Repository;

import com.agriculture_platform.Notification.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByUserId(String userId);
}
