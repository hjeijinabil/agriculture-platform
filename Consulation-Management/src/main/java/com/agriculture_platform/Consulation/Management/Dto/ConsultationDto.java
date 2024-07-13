package com.agriculture_platform.Consulation.Management.Dto;

import java.time.LocalDateTime;

public class ConsultationDto {
    private String id;
    private String farmerId; // User ID of the farmer
    private String consultantId; // User ID of the consultant
    private String mentorId; // User ID of the mentor
    private boolean accepted;

    public boolean isAccepted() {
        return accepted;
    }

    public  void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(String consultantId) {
        this.consultantId = consultantId;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }
// other fields as needed
}
