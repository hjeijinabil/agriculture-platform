package com.agriculture_platform.Notification.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;

    private String content;

    // Add the userToId field if you need it for your queries
    private String userToId;

    private NotificationType notificationType;

    private boolean delivered;
    private boolean read;
}
