package com.agriculture_platform.Authentication.Entity;

import jakarta.persistence.Entity;

@Entity
public class Enginner extends User {
    private String expertise;



    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }


}
