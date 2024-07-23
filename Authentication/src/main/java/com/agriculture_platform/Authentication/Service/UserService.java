package com.agriculture_platform.Authentication.Service;

import com.agriculture_platform.Authentication.Dto.UserDto;
import com.agriculture_platform.Authentication.Entity.User;

public interface UserService {
    User save (UserDto userDto);
     User getUserByUsername(String username);
}
