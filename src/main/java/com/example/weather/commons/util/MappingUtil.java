package com.example.weather.commons.util;

import com.example.weather.dto.UserRequestDto;
import com.example.weather.entity.User;
import org.modelmapper.ModelMapper;

public class MappingUtil {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();


    public static User convertToEntity(UserRequestDto userDto) {
        return MODEL_MAPPER.map(userDto, User.class);
    }
}
