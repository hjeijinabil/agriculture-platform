package com.agriculture_platform.ReviewFeedback.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedbackRequest {

    private  String id;
    private String consultationId;

}
