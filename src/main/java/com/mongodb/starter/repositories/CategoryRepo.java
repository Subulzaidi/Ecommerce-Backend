package com.mongodb.starter.repositories;

import com.mongodb.starter.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends MongoRepository<Category, String>{

    Category getById(int categoryId);

    Optional<Category> findById(int categoryId);
}
