package com.mongodb.starter.service;

import com.mongodb.starter.Exception.AuthenticationFailException;
import com.mongodb.starter.Exception.CustomExceptions;
import com.mongodb.starter.dto.User.Signindto;
import com.mongodb.starter.dto.User.Signupdto;
import com.mongodb.starter.dto.response.SignInResponsedto;
import com.mongodb.starter.dto.response.SignupResponsedto;
import com.mongodb.starter.models.AuthenticationToken;
import com.mongodb.starter.models.User;
import com.mongodb.starter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class UserService {@Autowired
UserRepository userRepository;
    @Autowired
    AuthenticationToken authenticationToken;
    @Autowired
    AuthenticationService authenticationService;
    @Transactional
    public SignupResponsedto signup(Signupdto signupdto) {
        //user already have an acc
        if (Objects.nonNull(userRepository.findByEmail(signupdto.getEmail()))) {
            throw new CustomExceptions("User already have an account");
        }
        //hash the password
        String encryptedpassword = signupdto.getPassword();
        try {
            encryptedpassword = hashPassword(signupdto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


        User user = new User(signupdto.getFirstname(), signupdto.getLastname(), signupdto.getEmail(), encryptedpassword);
        userRepository.save(user);
        //save the user
        //create the token
        final AuthenticationToken authenticationToken = new AuthenticationToken(user);

        authenticationService.saveConfirmationToken(authenticationToken);
        SignupResponsedto signupResponsedto = new SignupResponsedto("sucess", "dummy response");
        return signupResponsedto;
    }
        private String hashPassword(String password) throws NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest= md.digest();
            String hash= DatatypeConverter
                    .printHexBinary(digest).toUpperCase();
            return hash;
        }

        public SignInResponsedto signin(Signindto signindto) {
            //find by email
            User user=userRepository.findByEmail(signindto.getEmail());
            if(Objects.isNull(user)){
                throw new AuthenticationFailException("user is not valid");
            }
            //hash the password
            try {
                if(!user.getPassword().equals(hashPassword(signindto.getPassword())))
                {
                    throw new AuthenticationFailException("Wrong Password");
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            //compare the password in DB

            //if password match
            AuthenticationToken token=authenticationService.getToken(user);

            //retrive the token
            if(Objects.isNull(token)) {
                throw new CustomExceptions("Token is not present");
            }
            return new SignInResponsedto("Sucess",token.getToken());

        }




    }
