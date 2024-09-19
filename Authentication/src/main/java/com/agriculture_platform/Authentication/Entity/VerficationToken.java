package com.agriculture_platform.Authentication.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class VerficationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private LocalDateTime expirationDate;

    // Constructor
    public VerficationToken(String token) {
        this.token = token;
        this.expirationDate = LocalDateTime.now().plusMinutes(5);  // Token expires in 5 minutes
    }

    public VerficationToken() {

    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(this.expirationDate);
    }


    public Long getId() {
        return id;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setId(Long id) {
        this.id = id;
    }





}
