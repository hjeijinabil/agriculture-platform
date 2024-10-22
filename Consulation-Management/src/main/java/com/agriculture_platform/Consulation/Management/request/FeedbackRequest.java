package com.agriculture_platform.Consulation.Management.request;

import com.agriculture_platform.Consulation.Management.Dto.ConsultationDto;
import com.agriculture_platform.Consulation.Management.Dto.FeedbackDto;
import com.agriculture_platform.Consulation.Management.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class FeedbackRequest {
private  String id;
    private String consultationId;
    private ConsultationDto consultation ;
    private int rating;
    private String comments;
    private UserDto user;
    private String userType;
    private FeedbackDto feedback;
    private Long userId;



}
