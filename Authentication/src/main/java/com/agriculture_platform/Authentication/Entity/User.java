package com.agriculture_platform.Authentication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

import java.util.HashSet;

import java.util.Set;


@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String age;
    private String sex;
    private String email;

private String Roles;


    public User(String email, String password, String age, String sex, String username, String Roles) {
        super();
        this.email =email;
        this.password =password;
        this.age =age;
        this.sex= sex;
        this.username =username;
        this.Roles =Roles;
    }
}
