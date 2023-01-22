package com.mongodb.starter.controllers;

import com.mongodb.starter.models.User;
import com.mongodb.starter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
            user.setId(Integer.toString((int) (Math.random()*10000)));
            userRepo.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(@RequestBody User user) {

        if (!userRepo.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("No user with this email exists", HttpStatus.NOT_FOUND);
        }

        User checkUser = userRepo.findByEmail(user.getEmail());

        if (!checkUser.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>("Your password is incorrect", HttpStatus.FORBIDDEN);
        }
         else{
           return new ResponseEntity<User>(user, HttpStatus.OK);
       }
}
}

