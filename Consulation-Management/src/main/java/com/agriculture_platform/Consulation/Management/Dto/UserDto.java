package com.agriculture_platform.Consulation.Management.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.Set;
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    @Id
    private Long id;
    private String username;
    private String password;
    private String age;
    private String sex;
    private String email;
    private String Roles;


}
