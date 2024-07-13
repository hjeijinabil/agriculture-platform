package com.agriculture_platform.Consulation.Management.Service;

import com.agriculture_platform.Consulation.Management.Dto.ConsultationDto;
import com.agriculture_platform.Consulation.Management.Entity.ConsultationBookingEntity;
import com.agriculture_platform.Consulation.Management.Repository.ConsultationBookingRepository;
import com.agriculture_platform.Consulation.Management.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultationServiceImpl implements ConsultationService{
    @Autowired
    private ConsultationBookingRepository consultationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


   
    @Override
    public ConsultationDto bookConsultation(ConsultationDto consultationDTO) {
        // Map ConsultationDto to ConsultationBookingEntity using ModelMapper
        ConsultationBookingEntity consultation = modelMapper.map(consultationDTO, ConsultationBookingEntity.class);

//        // Retrieve farmer, consultant, and mentor entities from UserRepository
//        User farmer = userRepository.findById(consultationDTO.getFarmerId())
//                .orElseThrow(() -> new IllegalArgumentException("Farmer not found"));
//        User consultant = userRepository.findById(consultationDTO.getConsultantId())
//                .orElseThrow(() -> new IllegalArgumentException("Consultant not found"));
//        User mentor = userRepository.findById(consultationDTO.getMentorId())
//                .orElseThrow(() -> new IllegalArgumentException("Mentor not found"));
//
//        // Set farmer, consultant, and mentor entities to the consultation entity
//        consultation.setFarmer(farmer);
//        consultation.setConsultant(consultant);
//        consultation.setMentor(mentor);
        // Save consultation entity in the database using ConsultationRepository
        consultation = consultationRepository.save(consultation);

        // Map ConsultationBookingEntity back to ConsultationDto and return it
        return modelMapper.map(consultation, ConsultationDto.class);
    }

    @Override
    public List<ConsultationDto> findAvailableConsultations() {
        List<ConsultationBookingEntity> consultations = consultationRepository.findAll();
        return consultations.stream()
                .map(consultation -> modelMapper.map(consultation, ConsultationDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<ConsultationDto> findConsultationsByMentorId(String mentorId) {
        List<ConsultationBookingEntity> consultations = consultationRepository.findByMentorIdAndAccepted(mentorId, true);
        return consultations.stream()
                .map(consultation -> modelMapper.map(consultation, ConsultationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void acceptConsultation(String consultationId) {
        ConsultationBookingEntity consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new IllegalArgumentException("Consultation not found"));
        consultation.setAccepted(true);
        consultationRepository.save(consultation);
    }

    @Override
    public void rejectConsultation(String consultationId) {
        consultationRepository.deleteById(consultationId);
    }
}
