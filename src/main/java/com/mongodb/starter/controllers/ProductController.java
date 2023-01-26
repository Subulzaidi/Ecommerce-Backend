package com.mongodb.starter.controllers;

import com.mongodb.starter.common.ApiResponse;
import com.mongodb.starter.dto.ProductDto;
import com.mongodb.starter.models.Category;
import com.mongodb.starter.models.Product;
import com.mongodb.starter.models.User;
import com.mongodb.starter.repositories.CategoryRepo;
import com.mongodb.starter.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
@Autowired
    ProductService productService;
@Autowired
    CategoryRepo categoryRepo;
@PostMapping("/add")
public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
    Optional<Category> optionalCategory =categoryRepo.findById(productDto.getCategoryId());
    if(!optionalCategory.isPresent()) {
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.BAD_REQUEST);
    }
     productService.createProduct(productDto,optionalCategory.get());
     return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been added"),HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<List<ProductDto> > getproducts(){
         List<ProductDto> products=productService.getAllProducts();
         return new ResponseEntity<>(products,HttpStatus.OK);

    }
    @PostMapping("/update/{ProductId}")
    public ResponseEntity<ApiResponse> UpdateProduct(@PathVariable("ProductId") Integer ProductId, @RequestBody ProductDto productDto ) throws Exception {    Optional<Category> optionalCategory =categoryRepo.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.BAD_REQUEST);
        }
        productService.UpdateProduct(productDto, ProductId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been added"),HttpStatus.OK);
    }


    /* @DeleteMapping("/delete/{ProductId}") */



    }







