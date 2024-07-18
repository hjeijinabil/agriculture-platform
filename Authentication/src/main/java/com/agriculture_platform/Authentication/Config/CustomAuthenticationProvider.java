package com.agriculture_platform.Authentication.Config;

import com.agriculture_platform.Authentication.Entity.User;
import com.agriculture_platform.Authentication.Repository.UserRepository;
import com.agriculture_platform.Authentication.Service.CustomUserDetailsService;
import com.agriculture_platform.Authentication.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

import static com.agriculture_platform.Authentication.Config.SecurityConfig.passwordEncoder;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        Optional<User> user = userRepository.findByEmail(username);
        System.out.println("hello"+userDetails.getUsername()+"jjj");
        System.out.println("ttt"+ user.get().getRoles());
        // Implement your custom logic for password validation
        if (!passwordEncoder().matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        // Generate JWT upon successful authentication
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", user.get().getId());
        data.put("role", user.get().getRoles());
        data.put("age", user.get().getAge());
        data.put("username", user.get().getUsername());
        data.put("sexe", user.get().getSex());
        data.put("email", user.get().getEmail());
        String jwtToken = jwtService.generateToken(data,userDetails);
        JwtLocalStorage.setJwt(jwtToken);
        System.out.println("jwt = " + jwtToken);
        return new UsernamePasswordAuthenticationToken(username, jwtToken, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
  
}
