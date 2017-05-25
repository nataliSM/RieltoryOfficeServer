package ru.itis.inform.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.dto.UserRegistrationDto;
import ru.itis.inform.exeptions.ResourceNotFoundException;
import ru.itis.inform.models.User;
import ru.itis.inform.repositories.UserRepository;
import ru.itis.inform.security.utils.Role;
import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.UsersService;

import javax.jws.soap.SOAPBinding;

/**
 * Created by acacuce on 12.05.17.
 */
@Component
public class UsersServiceImpl implements UsersService{
    @Autowired
    TokenService tokenService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public String login(String password, String login) {
        User user = userRepository.findByUsername(login);
        if (user == null) {
            throw new ResourceNotFoundException("Wrong password or login");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String hashedPassword = user.getPassword();

        if (bCryptPasswordEncoder.matches(password, hashedPassword)) {
            return tokenService.generateTokenString(user);
        }else {
            throw new ResourceNotFoundException("Wrong password or login");
        }

    }

    public UserDto registerUser(UserRegistrationDto userRegistrationDto, Role role) {
        User user = modelMapper.map(userRegistrationDto, User.class);
        user.setRole(role.toString());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String hashedPassword = bCryptPasswordEncoder.encode(userRegistrationDto.getPassword());
        user.setPassword(hashedPassword);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }
}
