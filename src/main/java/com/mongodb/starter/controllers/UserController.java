package com.mongodb.starter.controllers;

import com.mongodb.starter.models.User;
import com.mongodb.starter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class UserController{

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody User user){
        if(userRepo.existsByEmail(user.getEmail())){
            return new ResponseEntity<>("The user with the email "+ user.getEmail()+ "already exists ", HttpStatus.FORBIDDEN);
        }else{
            user.setCreatedAt(new Date());
            userRepo.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

    }
}
