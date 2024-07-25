package com.agriculture_platform.Consulation.Management.Service;
import com.agriculture_platform.Consulation.Management.Config.ResourceNotFoundException;

import com.agriculture_platform.Consulation.Management.Dto.ConsultationDto;
import com.agriculture_platform.Consulation.Management.Dto.FeedbackDto;
import com.agriculture_platform.Consulation.Management.Dto.UserDto;
import com.agriculture_platform.Consulation.Management.Entity.ConsultationBookingEntity;
import com.agriculture_platform.Consulation.Management.Repository.ConsultationBookingRepository;
import com.agriculture_platform.Consulation.Management.request.FeedbackRequest;
import com.agriculture_platform.Consulation.Management.request.NotificationRequest;
import com.agriculture_platform.Consulation.Management.request.NotificationType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ConsultationServiceImpl implements ConsultationService{
    @Autowired
    private ConsultationBookingRepository consultationRepository;


    @Autowired
    private ModelMapper modelMapper;

@Autowired
private UserServiceClient userServiceClient;
@Autowired
private CommentServiceClient commentServiceClient;

    @Autowired
    private NotificationServiceClient notificationServiceClient;

    public ConsultationBookingEntity create(ConsultationBookingEntity consultation) {
        UserDto user = userServiceClient.getUserByUsername(consultation.getUser().getUsername());
        consultation.setUser(user);
        consultation.setFeedback(new ArrayList<>());
        consultation.setLikedUsers(new ArrayList<>());
        consultation.setCreated(LocalDateTime.now());
        return consultationRepository.save(consultation);
    }

    @Override
    public ConsultationDto addFeedback(FeedbackRequest feedbackRequest) {
        // 1. Retrieve the consultation from the repository
        ConsultationBookingEntity consultationEntity = consultationRepository.findById(feedbackRequest.getConsultationId())
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with ID: " + feedbackRequest.getConsultationId()));

        // 2. Fetch the user from the user service
        UserDto feedbackUser = userServiceClient.getUserByUsername(feedbackRequest.getUser().getUsername());
        if (feedbackUser == null) {
            throw new ResourceNotFoundException("User not found with username: " + feedbackRequest.getUser().getUsername());
        }

        // 3. Create and set feedback object
        FeedbackDto feedbackDto = feedbackRequest.getFeedback();
        feedbackDto.setUser(feedbackUser);

        // Add the feedback to the consultation
        consultationEntity.getFeedback().add(modelMapper.map(feedbackDto, FeedbackDto.class));

        // 4. Notify the consultation owner
        UserDto consultationOwner = userServiceClient.getUserByUsername(consultationEntity.getUser().getUsername());
        NotificationRequest notificationRequest = new NotificationRequest(
                false,
                "New feedback from " + feedbackUser.getUsername(),
                NotificationType.COMMENT,
                feedbackUser,
                consultationOwner
        );

        notificationServiceClient.createNotification(notificationRequest);

        // 5. Save the updated consultation
        consultationRepository.save(consultationEntity);

        // Convert updated entity to DTO and return
        return modelMapper.map(consultationEntity, ConsultationDto.class);
    }
    @Override
    public ConsultationDto removeFeedback(FeedbackRequest feedbackRequest) {
        // 1. Retrieve the consultation from the repository
        ConsultationBookingEntity consultationEntity = consultationRepository.findById(feedbackRequest.getConsultationId())
                .orElseThrow(() -> new ResourceNotFoundException("Consultation not found with ID: " + feedbackRequest.getConsultationId()));

        // 2. Fetch the feedback to be removed
        FeedbackDto feedbackToRemove = feedbackRequest.getFeedback();

        // 3. Remove the feedback from the consultation
        List<FeedbackDto> updatedFeedbackList = consultationEntity.getFeedback().stream()
                .filter(feedback -> !Objects.equals(feedback.getId(), feedbackToRemove.getId()))
                .collect(Collectors.toList());
        consultationEntity.setFeedback(updatedFeedbackList);

        // 4. Notify the consultation owner about the removal (optional)
        UserDto consultationOwner = userServiceClient.getUserByUsername(consultationEntity.getUser().getUsername());
        NotificationRequest notificationRequest = new NotificationRequest(
                false,
                "Feedback removed by " + feedbackToRemove.getUser().getUsername(),
                NotificationType.COMMENT,
                feedbackToRemove.getUser(),
                consultationOwner
        );

        notificationServiceClient.createNotification(notificationRequest);

        // 5. Save the updated consultation
        consultationRepository.save(consultationEntity);

        // Convert updated entity to DTO and return
        return modelMapper.map(consultationEntity, ConsultationDto.class);
    }


    @Override
    public ConsultationDto bookConsultation(ConsultationDto consultationDTO) {
        // Map ConsultationDto to ConsultationBookingEntity using ModelMapper
        ConsultationBookingEntity consultation = modelMapper.map(consultationDTO, ConsultationBookingEntity.class);

        // Retrieve farmer, consultant, and mentor entities from UserRepository
        // Uncomment the code below if needed
        /*
        User farmer = userRepository.findById(consultationDTO.getFarmerId())
                .orElseThrow(() -> new IllegalArgumentException("Farmer not found"));
        User consultant = userRepository.findById(consultationDTO.getConsultantId())
                .orElseThrow(() -> new IllegalArgumentException("Consultant not found"));
        User mentor = userRepository.findById(consultationDTO.getMentorId())
                .orElseThrow(() -> new IllegalArgumentException("Mentor not found"));

        consultation.setFarmer(farmer);
        consultation.setConsultant(consultant);
        consultation.setMentor(mentor);
        */

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

//    @Override
//    public List<ConsultationDto> findConsultationsByMentorId(String mentorId) {
//        List<ConsultationBookingEntity> consultations = consultationRepository.findByMentorIdAndAccepted(mentorId, true);
//        return consultations.stream()
//                .map(consultation -> modelMapper.map(consultation, ConsultationDto.class))
//                .collect(Collectors.toList());
//    }

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


//    public ConsultationDto addFeeback(FeedbackRequest feedbackRequest) {
//        ConsultationBookingEntity consultationDto = getConsultationByID(feedbackRequest.getConsultation().getI);
//        F = commentRequest.getComment();
//        // it's checking users at the same time
//        User commentUser = userService.getUserByUsername(comment.getUser().getUsername());
//        comment.setUser(commentUser);
//        comment.setId(new ObjectId().toString());
//        User postUser = userService.getUserByUsername(post.getUser().getUsername());
//        post.setUser(postUser);
//        post.getComments().add(comment);
//        notificationStorageService.createNotificationStorage(Notification.builder()
//                .delivered(false)
//                .content("new comment from " + commentUser.getUsername())
//                .notificationType(NotificationType.COMMENT)
//                .userFrom(commentUser)
//                .userTo(postUser).build());
//        return postRepository.save(post);
//    }
}
