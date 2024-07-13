package com.agriculture_platform.Consulation.Management.Dto;

import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserDto {
    private String id;
    private String username;
    private String email;
    private Set<String> roles; // Roles of the user

}
