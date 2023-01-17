package com.mongodb.starter.repositories;

import com.mongodb.starter.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    Boolean existsByEmail(String email);

}
