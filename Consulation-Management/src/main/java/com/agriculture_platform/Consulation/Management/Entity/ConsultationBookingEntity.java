package com.agriculture_platform.Consulation.Management.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "users")

public class ConsultationBookingEntity {
    @Id
    private String id;


    private User farmer; // User booking the consultation (farmer)
    private boolean accepted;

    private User consultant; // Consultant selected for the consultation
     private double AvergadeRating;


    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }


    public double getAvergadeRating() {
        return AvergadeRating;
    }

    public void setAvergadeRating(double avergadeRating) {
        AvergadeRating = avergadeRating;
    }

    private int numberOfReviews;
    public boolean isAccepted() {
        return accepted;
    }


    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public User getConsultant() {
        return consultant;
    }

    public void setConsultant(User consultant) {
        this.consultant = consultant;
    }

    public User getFarmer() {
        return farmer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFarmer(User farmer) {
        this.farmer = farmer;
    }

    public User getMentor() {
        return mentor;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    private User mentor; // Mentor providing consultation

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
