package com.agriculture_platform.Authentication.Service;


import com.agriculture_platform.Authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.agriculture_platform.Authentication.Entity.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("user not found");
        }

        return new CustomUserDetail(user.get());

    }

}
