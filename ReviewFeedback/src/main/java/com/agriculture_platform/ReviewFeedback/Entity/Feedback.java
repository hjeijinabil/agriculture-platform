package com.agriculture_platform.ReviewFeedback.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userType;
    private Long userId;
    private Long consultantId;
    private int rating;
    private String comments;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComments() {
        return comments;
    }

    public Long getConsultantId() {
        return consultantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConsultantId(Long consultantId) {
        this.consultantId = consultantId;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }



}
