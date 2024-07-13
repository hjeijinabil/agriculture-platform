package com.agriculture_platform.Consulation.Management.Service;

import com.agriculture_platform.Consulation.Management.Dto.ConsultationDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationService {
    ConsultationDto bookConsultation(ConsultationDto consultationDTO);
    List<ConsultationDto> findAvailableConsultations();

    List<ConsultationDto> findConsultationsByMentorId(String mentorId);
    void acceptConsultation(String consultationId);
    void rejectConsultation(String consultationId);
}
