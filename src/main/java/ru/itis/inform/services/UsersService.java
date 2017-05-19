package ru.itis.inform.services;

/**
 * Created by acacuce on 12.05.17.
 */
public interface UsersService {

//    UserDto registerUser(UserDataForRegistrationDto user);
    String login(String password, String login);

}
