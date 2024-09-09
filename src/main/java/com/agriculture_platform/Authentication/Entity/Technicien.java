package com.agriculture_platform.Authentication.Entity;

import jakarta.persistence.Entity;

@Entity
public class Technicien extends User {
    private String specialization;


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


}
