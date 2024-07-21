package com.agriculture_platform.ReviewFeedback.Repository;

import com.agriculture_platform.ReviewFeedback.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
    @Query("SELECT COALESCE(AVG(r.rating), 0) FROM Feedback r WHERE r.consultation.id = :consultationId")
    double findAverageRatingByconsultationId(@Param("consultationId") Long consultationId);

    @Query("SELECT COUNT(r) FROM Feedback r WHERE r.consultation.id = :consultationId")
    int countReviewsByConsultationId(@Param("consultationId") Long consultationId);

}
