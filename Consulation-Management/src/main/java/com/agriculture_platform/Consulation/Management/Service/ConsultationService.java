package com.agriculture_platform.Consulation.Management.Service;

import com.agriculture_platform.Consulation.Management.Dto.ConsultationDto;
import com.agriculture_platform.Consulation.Management.Dto.FeedbackDto;
import com.agriculture_platform.Consulation.Management.Entity.ConsultationBookingEntity;
import com.agriculture_platform.Consulation.Management.request.FeedbackRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationService {
    ConsultationDto addFeedback(FeedbackRequest feedbackRequest);
    ConsultationDto removeFeedback(FeedbackRequest feedbackRequest);
    ConsultationDto bookConsultation(ConsultationDto consultationDTO);
    List<ConsultationDto> findAvailableConsultations();
    ConsultationBookingEntity create(ConsultationBookingEntity consultation);
    //    List<ConsultationDto> findConsultationsByMentorId(String mentorId);
    void acceptConsultation(String consultationId);
    void rejectConsultation(String consultationId);
}
