package com.mongodb.starter.repositories;

import com.mongodb.starter.models.AuthenticationToken;
import com.mongodb.starter.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TokenRepository extends MongoRepository<User,String > {
    AuthenticationToken findByUser(User user);
    void save(AuthenticationToken authenticationToken);

}
