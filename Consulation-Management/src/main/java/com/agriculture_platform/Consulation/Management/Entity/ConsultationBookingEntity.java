package com.agriculture_platform.Consulation.Management.Entity;


import com.agriculture_platform.Consulation.Management.Dto.FeedbackDto;
import com.agriculture_platform.Consulation.Management.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "consultations")
@Getter
@Setter
@AllArgsConstructor
public class ConsultationBookingEntity {
    @Id
    private String id;


    private boolean accepted;

    private String content;
    private UserDto user;
    private List<UserDto> likedUsers;
    private List<FeedbackDto> feedback;
    private LocalDateTime created;
    private String postImageUrl;

    public ConsultationBookingEntity() {

    }
}
