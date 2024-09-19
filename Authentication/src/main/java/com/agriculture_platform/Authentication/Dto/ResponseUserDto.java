package com.agriculture_platform.Authentication.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String age;
    private String sex;
    private String email;
    private String Roles;
    public ResponseUserDto(String email, String username, String age, String sex, String Roles) {
        this.email = email;
        this.username = username;
        this.age =  age;
        this.sex = sex;
        this.Roles = Roles;
    }
}

