package com.mongodb.starter.service;

import com.mongodb.starter.dto.ProductDto;
import com.mongodb.starter.models.Category;
import com.mongodb.starter.models.Product;
import com.mongodb.starter.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDesc(productDto.getPdesc());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setId(product.getId());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        productRepository.save(product);

    }

    public ProductDto getProductDto(Product product) {ProductDto productDto = new ProductDto();
        productDto.setPdesc(product.getDesc());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        return productDto;

    }

    public List<ProductDto> getAllProducts() {
        List<Product> allproducts = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : allproducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void UpdateProduct(ProductDto productDto, Integer productId) throws Exception {
     Optional<Product>  optionalProduct= productRepository.findById(productId);
     if(!optionalProduct.isPresent()){
         throw new Exception("Product not present");
     }
        Product product =  optionalProduct.get();
        product.setDesc(productDto.getPdesc());
        product.setName(productDto.getName());

        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        productRepository.save(product);


    }


}