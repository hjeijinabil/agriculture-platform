package com.agriculture_platform.Consulation.Management.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ConsultationDto {
    private String id;

    private boolean accepted;
    private String consultationId;
    private String content;
    private UserDto user;
    private List<UserDto> likedUsers;
    private List<FeedbackDto> feedback;
    private LocalDateTime created;
    private String postImageUrl;

}
