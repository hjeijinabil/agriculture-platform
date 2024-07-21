package com.agriculture_platform.ReviewFeedback.Service;

import com.agriculture_platform.ReviewFeedback.Entity.Feedback;
import com.agriculture_platform.ReviewFeedback.Repository.FeedbackRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback(Long id, Feedback feedback) {
        Feedback existingFeedback = feedbackRepository.findById(id).orElse(null);
        if (existingFeedback != null) {
            existingFeedback.setRating(feedback.getRating());
            existingFeedback.setComments(feedback.getComments());
            return feedbackRepository.save(existingFeedback);
        }
        return null;
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
//    @Transactional
//    public void calculateAverageRating(Long consultationId) {
//        double averageRating = FeedbackRepository.findAverageRatingByConsultationId(consultationId);
//        int numOfReviews = feedbackRepository.countReviewsByConsultationId(consultationId);
//
//        ConsultationRepository.findById(consultationId).ifPresent(user -> {
//            user.setAverageRating(Math.ceil(averageRating));
//            user.setNumOfReviews(numOfReviews);
//            userRepository.save(user);
//        });
//    }

}
