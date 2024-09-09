package com.agriculture_platform.Authentication.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class Dto {

    private String username;

    private String age;
    private String sex;
    private String email;
    private String Roles;
}
