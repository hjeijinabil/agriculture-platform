package com.agriculture_platform.Consulation.Management.Controller;

import com.agriculture_platform.Consulation.Management.Config.ResourceNotFoundException;
import com.agriculture_platform.Consulation.Management.Dto.ConsultationDto;
import com.agriculture_platform.Consulation.Management.Entity.ConsultationBookingEntity;
import com.agriculture_platform.Consulation.Management.Service.ConsultationService;
import com.agriculture_platform.Consulation.Management.request.FeedbackRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/consultations")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    @PostMapping("create")
    public ResponseEntity<ConsultationDto> createConsultation(@RequestBody ConsultationBookingEntity consultationRequest) {
        try {
            // Crée la consultation et récupère la consultation DTO
            ConsultationBookingEntity createdConsultation = consultationService.create(consultationRequest);

            // Convertit l'entité créée en DTO pour la réponse
            ConsultationDto consultationDto = new ModelMapper().map(createdConsultation, ConsultationDto.class);

            return new ResponseEntity<>(consultationDto, HttpStatus.CREATED);
        } catch (Exception e) {
            // Gérez les exceptions spécifiques et les erreurs ici
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/feedback")
    public ResponseEntity<ConsultationDto> addFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        try {
            ConsultationDto updatedConsultation = consultationService.addFeedback(feedbackRequest);
            return new ResponseEntity<>(updatedConsultation, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Endpoint to remove feedback
    @DeleteMapping("/feedback")
    public ResponseEntity<ConsultationDto> removeFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        try {
            ConsultationDto consultationDto = consultationService.removeFeedback(feedbackRequest);
            return new ResponseEntity<>(consultationDto, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and provide appropriate response
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/book")
    public ResponseEntity<ConsultationDto> bookConsultation(@RequestBody ConsultationDto consultationDTO) {
        ConsultationDto bookedConsultation = consultationService.bookConsultation(consultationDTO);
        return new ResponseEntity<>(bookedConsultation, HttpStatus.CREATED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<ConsultationDto>> findAvailableConsultations() {

        List<ConsultationDto> availableConsultations = consultationService.findAvailableConsultations();
        return ResponseEntity.ok(availableConsultations);
    }
//    @GetMapping("/mentor/{mentorId}")
//    public ResponseEntity<List<ConsultationDto>> getConsultationsByMentorId(@PathVariable String mentorId) {
//        List<ConsultationDto> consultations = consultationService.findConsultationsByMentorId(mentorId);
//        return ResponseEntity.ok(consultations);
//    }

    @PutMapping("/{consultationId}/accept")
    public ResponseEntity<Void> acceptConsultation(@PathVariable String consultationId) {
        consultationService.acceptConsultation(consultationId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{consultationId}/reject")
    public ResponseEntity<Void> rejectConsultation(@PathVariable String consultationId) {
        consultationService.rejectConsultation(consultationId);
        return ResponseEntity.noContent().build();
    }
}
