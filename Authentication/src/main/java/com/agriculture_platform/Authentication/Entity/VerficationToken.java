package com.agriculture_platform.Authentication.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class VerficationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private Date expiryDate;

    public VerficationToken() {

    }



    public Long getId() {
        return id;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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


    public boolean isExpired() {
        return new Date().after(expiryDate);
    }

    public VerficationToken(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public VerficationToken(String token) {
        this.token = token;
    }
}
