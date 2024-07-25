package com.agriculture_platform.Consulation.Management.request;

import com.agriculture_platform.Consulation.Management.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NotificationRequest {
    private boolean delivered;
    private String content;
    private NotificationType notificationType;
    private UserDto userFrom;
    private UserDto userTo;
}
