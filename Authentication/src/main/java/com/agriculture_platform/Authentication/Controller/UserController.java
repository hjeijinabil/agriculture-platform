package com.agriculture_platform.Authentication.Controller;

import com.agriculture_platform.Authentication.Dto.UserDto;
import com.agriculture_platform.Authentication.Entity.User;
import com.agriculture_platform.Authentication.Repository.UserRepository;
import com.agriculture_platform.Authentication.Service.CustomUserDetail;
import com.agriculture_platform.Authentication.Service.CustomUserDetailsService;
import com.agriculture_platform.Authentication.Service.JwtService;
import com.agriculture_platform.Authentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired

    private UserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @PostMapping("/registration")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        // Check if the email already exists
        if (userRepository.existsByEmail(userDto.getEmail())) {
            // Return ResponseEntity with a conflict status and message
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exists in the database");
        }

        // Save the user if email doesn't exist
        userService.save(userDto);

        // Return ResponseEntity with OK status and success message
        return ResponseEntity.ok("Registered Successfully!");
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> createAuthenticationToken(@RequestBody UserDto userDto) throws
            BadCredentialsException,
            DisabledException,
            UsernameNotFoundException {
        Authentication authentication;
        try {
            System.out.println("hello");
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));

        } catch (AuthenticationException e) {
            System.out.println(e);
            if (e instanceof LockedException) {
                // Handle locked account
                System.out.println("User account is locked");
                throw new LockedException("User account is locked");
            } else {
                // Handle other authentication failures
                System.out.println("Authentication failed: " + e.getMessage());
                throw new BadCredentialsException("Incorrect username or password");
            }
        }
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(userDto.getEmail());

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
//        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        String jwt;
        if (optionalUser.isPresent()){
            HashMap<String, Object> data = new HashMap<>();
        data.put("id", optionalUser.get().getId());
        data.put("role", optionalUser.get().getRoles());
        data.put("age", optionalUser.get().getAge());
        data.put("username", optionalUser.get().getUsername());
        data.put("sexe", optionalUser.get().getSex());
        data.put("email", optionalUser.get().getEmail());
            jwt = jwtService.generateToken(data , new CustomUserDetail(optionalUser.get()));
        }
        else
            jwt = jwtService.generateToken( userDetails);
        UserDto userDto1 = new UserDto();
        if (optionalUser.isPresent()) {

            userDto1.setJwt(jwt);
            userDto1.setEmail(optionalUser.get().getEmail());
            userDto1.setAge(optionalUser.get().getAge());
            userDto1.setId(optionalUser.get().getId());
            userDto1.setRoles(optionalUser.get().getRoles());
        }
//        return authenticationResponse;
        return ResponseEntity.ok(userDto1);
    }


}




