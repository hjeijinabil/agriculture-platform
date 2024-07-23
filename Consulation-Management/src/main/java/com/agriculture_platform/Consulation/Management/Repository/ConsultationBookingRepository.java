package com.agriculture_platform.Consulation.Management.Repository;

import com.agriculture_platform.Consulation.Management.Dto.ConsultationDto;
import com.agriculture_platform.Consulation.Management.Entity.ConsultationBookingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultationBookingRepository extends MongoRepository<ConsultationBookingEntity, String> {
    List<ConsultationBookingEntity> findByMentorIdAndAccepted(String mentorId, boolean accepted);
    List<ConsultationBookingEntity> findConsultationById(String id);
    ConsultationDto getByIdConsultation(String consultationId);

}
