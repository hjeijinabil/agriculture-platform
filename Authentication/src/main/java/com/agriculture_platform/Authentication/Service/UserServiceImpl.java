package com.agriculture_platform.Authentication.Service;

import com.agriculture_platform.Authentication.Dto.UserDto;
import com.agriculture_platform.Authentication.Entity.User;
import com.agriculture_platform.Authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;



    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getAge(), userDto.getSex() , userDto.getUsername(), userDto.getRoles());
        return userRepository.save(user);
    }
}
