package com.agriculture_platform.Consulation.Management.Dto;

import com.agriculture_platform.Consulation.Management.request.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@AllArgsConstructor
public class NotificationDto {
    @Id
    private String id;

    private String content;

    private UserDto userTo;

    private UserDto userFrom;

    private NotificationType notificationType;

    private boolean delivered;
    private boolean read;
}
