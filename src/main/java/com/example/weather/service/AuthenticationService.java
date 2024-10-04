package com.example.weather.service;

import com.example.weather.dao.UserDao;
import com.example.weather.dto.UserRequestDto;
import com.example.weather.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import static com.example.weather.commons.util.MappingUtil.convertToEntity;


public class AuthenticationService {

private final UserDao userDao = new UserDao();


    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    public User add(UserRequestDto userDto) {
        String hashedPassword = hashPassword(userDto.getPassword());
        userDto.setPassword(hashedPassword);

        return userDao.add(convertToEntity(userDto));
    }
}
