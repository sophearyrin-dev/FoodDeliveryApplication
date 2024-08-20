package com.food.userservice.mapper;

import com.food.userservice.dto.UserDTO;
import com.food.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);
}
