package com.food.userservice.service;

import com.food.userservice.dto.UserDTO;
import com.food.userservice.entity.User;
import com.food.userservice.mapper.UserMapper;
import com.food.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream().map(user -> UserMapper.INSTANCE.mapUserToUserDTO(user)).collect(Collectors.toList());
        return userDTOS;
    }

    public UserDTO addUserToDb(UserDTO userDTO) {
        User user = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(user);
    }

    public ResponseEntity<UserDTO> getUserById(int userId) {
        Optional<User> userFound = userRepository.findById(userId);
        if(userFound.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(userFound.get()), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND );
    }
}
