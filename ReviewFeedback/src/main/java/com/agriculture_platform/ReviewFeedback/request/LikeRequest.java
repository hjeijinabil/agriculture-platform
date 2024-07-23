package com.agriculture_platform.ReviewFeedback.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.catalina.User;

@Data
@AllArgsConstructor
public class LikeRequest {

    private String consultation ;
    private String user;

    public String getConsultation() {
        return consultation;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }
}
