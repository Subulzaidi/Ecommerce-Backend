package com.mongodb.starter.service;

import com.mongodb.starter.models.AuthenticationToken;
import com.mongodb.starter.models.User;
import com.mongodb.starter.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationService  {
    @Autowired
TokenRepository tokenRepository;
        public void saveConfirmationToken(AuthenticationToken authenticationToken) {
            tokenRepository.save(authenticationToken);
        }

        private static AuthenticationToken getAuthenticationToken(AuthenticationToken authenticationToken) {
            return authenticationToken;
        }

        public AuthenticationToken getToken(User user) {
            return tokenRepository.findByUser(user);
        }

}
