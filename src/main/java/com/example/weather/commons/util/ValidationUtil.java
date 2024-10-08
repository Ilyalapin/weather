package com.example.weather.commons.util;

import com.example.weather.dto.UserRequestDto;
import com.example.weather.commons.exception.InvalidParameterException;

public class ValidationUtil {
    public static void validate(UserRequestDto userDto) {
        if (userDto.getLogin() == null || userDto.getLogin().isEmpty()) {
            throw new InvalidParameterException("Missing parameter - name");
        }
        if (!userDto.getLogin().matches("/^[0-9A-Za-z]{3,10}$/")) {
            throw new InvalidParameterException("Invalid parameter: login must contain only letters and numbers" +
                    " and contain from 3 to 10 characters");
        }
        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            throw new InvalidParameterException("Missing parameter - password");
        }
        if (!userDto.getPassword().matches("/^(?=.*?[0-9])(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[^0-9A-Za-z]).{6,20}$/")) {
            throw new InvalidParameterException("Invalid parameter: password must contain: " +
                    " at least one number," +
                    " one lowercase letter," +
                    " one uppercase letter," +
                    " one special character " +
                    "and contain from 6 to 20 characters");
        }

    }
}
