package com.mongodb.starter.controllers;

import com.mongodb.starter.dto.User.Signindto;
import com.mongodb.starter.dto.User.Signupdto;
import com.mongodb.starter.dto.response.SignInResponsedto;
import com.mongodb.starter.dto.response.SignupResponsedto;
import com.mongodb.starter.repositories.UserRepository;
import com.mongodb.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController{

    @Autowired
    private UserRepository userRepo;

   /* @PostMapping("/signup")
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
}*/
    @Autowired
    UserService userService;
   @PostMapping("/signup")

   public SignupResponsedto signup (@RequestBody Signupdto signup){
       return userService.signup(signup);
   }

    @PostMapping("/signin")
    public SignInResponsedto signIn(@RequestBody Signindto signindto){

        return userService.signin(signindto);
    }





}

