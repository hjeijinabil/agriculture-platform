package com.agriculture_platform.Consulation.Management.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ConsultationDto {
    private Long id;

    private boolean accepted;
    private String consultationId;
    private String content;
    private UserDto user;
    private List<UserDto> likedUsers;
    private List<FeedbackDto> feedback;
    private LocalDateTime created;
    private String postImageUrl;

}
