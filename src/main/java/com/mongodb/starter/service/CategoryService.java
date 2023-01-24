package com.mongodb.starter.service;

import com.mongodb.starter.models.Category;
import com.mongodb.starter.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
@Autowired
    CategoryRepo categoryRepo;
 public void CreateCategory(Category category){
     categoryRepo.save(category) ;
 }
    public List<Category> listCategory(){
        return categoryRepo.findAll();
    }

    public void editCategory(int categoryId, Category updatecategory) {
     Category category= categoryRepo.getById(categoryId);
     category.setName(updatecategory.getName());
     category.setDesc(updatecategory.getDesc());
     categoryRepo.save(category);
    }

    public boolean findById(int categoryId) {
    return categoryRepo.findById(categoryId).isPresent();

 }
}
