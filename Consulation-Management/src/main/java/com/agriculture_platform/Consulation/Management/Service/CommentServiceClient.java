package com.agriculture_platform.Consulation.Management.Service;

import com.agriculture_platform.Consulation.Management.Dto.FeedbackDto;
import com.agriculture_platform.Consulation.Management.request.FeedbackRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "feedback-like-service")
public interface CommentServiceClient {
    @PostMapping("/feedback")
    FeedbackDto addFeedback(FeedbackRequest feedbackRequest);
}
