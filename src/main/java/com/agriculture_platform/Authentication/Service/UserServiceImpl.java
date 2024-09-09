package com.agriculture_platform.Authentication.Service;

import com.agriculture_platform.Authentication.Dto.Dto;
import com.agriculture_platform.Authentication.Dto.UserDto;
import com.agriculture_platform.Authentication.Entity.User;
import com.agriculture_platform.Authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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



    public   Dto getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // Map the User entity to UserDTO
        Dto userDTO = new Dto();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setAge(user.getAge());
        userDTO.setSex(user.getSex());
        userDTO.setRoles(user.getRoles());
        // Set other fields as needed

        return userDTO; }
    public User getUserById(Long id) {
        return userRepository.findUserById( id)
                .orElseThrow(() -> new RuntimeException("user not found!"));
    }

    protected boolean isUserContains(final List<User> list, final String username) {
        return list.stream().anyMatch(o -> o.getUsername().equals(username));
    }

}
