package com.agriculture_platform.ReviewFeedback.Repository;

import com.agriculture_platform.ReviewFeedback.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
}
