package com.agriculture_platform.Consulation.Management.Service;

import com.agriculture_platform.Consulation.Management.Dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto createUser(UserDto userDTO);
    UserDto   updateUser(UserDto userDTO);
    UserDto getUserById(String id);
    void deleteUserById(String id);
    UserDto findByUsername(String username);
}
