package com.agriculture_platform.Consulation.Management.Controller;

import com.agriculture_platform.Consulation.Management.Dto.ConsultationDto;
import com.agriculture_platform.Consulation.Management.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/bookings")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

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
    @GetMapping("/mentor/{mentorId}")
    public ResponseEntity<List<ConsultationDto>> getConsultationsByMentorId(@PathVariable String mentorId) {
        List<ConsultationDto> consultations = consultationService.findConsultationsByMentorId(mentorId);
        return ResponseEntity.ok(consultations);
    }

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
