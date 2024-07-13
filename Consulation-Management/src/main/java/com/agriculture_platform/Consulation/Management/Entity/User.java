package com.agriculture_platform.Consulation.Management.Entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private Set<String> roles; // 'ROLE_FARMER', 'ROLE_CONSULTANT', 'ROLE_MENTOR'
}
