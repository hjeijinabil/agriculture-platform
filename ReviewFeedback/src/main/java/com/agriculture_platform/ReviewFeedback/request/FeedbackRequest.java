package com.agriculture_platform.ReviewFeedback.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedbackRequest {

    private String consultation ;
    private String comment;

    public String getComment() {
        return comment;
    }

    public String getConsultation() {
        return consultation;
    }

    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
