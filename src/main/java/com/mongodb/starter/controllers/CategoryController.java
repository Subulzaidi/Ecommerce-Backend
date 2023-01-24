package com.mongodb.starter.controllers;

import com.mongodb.starter.common.ApiResponse;
import com.mongodb.starter.models.Category;
import com.mongodb.starter.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> CreateCategory(@RequestBody Category category){
    categoryService.CreateCategory(category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"a new category created"), HttpStatus.CREATED);

    }

    @GetMapping("/list")
    public List<Category> ListCategory(){
        return categoryService.listCategory();
    }
    @PostMapping("/update/{CategoryId}")
    public ResponseEntity<ApiResponse> UpdateCategory(@PathVariable("CategoryId") int categoryId,@RequestBody Category category ){
        System.out.println("Category Id"+ categoryId);
        if(!categoryService.findById(categoryId)){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false,"category does not exist"),HttpStatus.NOT_FOUND);

        }

        categoryService.editCategory(categoryId,category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"category has been updated"),HttpStatus.OK);
    }



}
