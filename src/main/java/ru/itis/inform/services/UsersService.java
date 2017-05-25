package ru.itis.inform.services;

import ru.itis.inform.dto.UserDto;
import ru.itis.inform.dto.UserRegistrationDto;
import ru.itis.inform.security.utils.Role;

/**
 * Created by acacuce on 12.05.17.
 */
public interface UsersService {

//    UserDto registerUser(UserDataForRegistrationDto user);
    String login(String password, String login);

    public UserDto registerUser(UserRegistrationDto userRegistrationDto, Role role);

}
