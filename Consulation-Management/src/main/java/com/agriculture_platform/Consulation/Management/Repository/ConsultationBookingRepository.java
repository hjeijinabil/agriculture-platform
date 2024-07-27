package com.agriculture_platform.Consulation.Management.Repository;

import com.agriculture_platform.Consulation.Management.Entity.ConsultationBookingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsultationBookingRepository extends MongoRepository<ConsultationBookingEntity, String> {
//    List<ConsultationBookingEntity> findByMentorIdAndAccepted(String mentorId, boolean accepted);

}
