package com.food.userservice.controller;

import com.food.userservice.dto.UserDTO;
import com.food.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-delivery-app/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.addUserToDb(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserByUserId(@PathVariable int userId){
        return userService.getUserById(userId);
    }
}
