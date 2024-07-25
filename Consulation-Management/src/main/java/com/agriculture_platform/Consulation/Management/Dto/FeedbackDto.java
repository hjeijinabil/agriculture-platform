package com.agriculture_platform.Consulation.Management.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@AllArgsConstructor
public class FeedbackDto {
    @Id
    private Long id;
    private String userType;
    private Long userId;
    private Long consultationId;
    private int rating;
    private String comments;
    private UserDto User;
}
