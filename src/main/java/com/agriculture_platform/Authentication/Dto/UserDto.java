package com.agriculture_platform.Authentication.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String Jwt;
    private String username;

    private String password;
    private String age;
    private String sex;
    private String email;
    private String Roles;
//    @ElementCollection(targetClass = Role.class)
//    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> Roles = new HashSet<>();
    public UserDto(String email, String password, String age, String sex, String username, String Roles) {
        super();
        this.email =email;
        this.password =password;
        this.age =age;
        this.sex= sex;
        this.username =username;
        this.Roles =Roles;
    }
}
