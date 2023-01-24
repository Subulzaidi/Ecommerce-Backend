package com.mongodb.starter.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Category")
public class Category {
    @Id
    private int id;
    private String name;
    private String desc;
    @DBRef
    private List<Product> product=new ArrayList<>();

    public Category(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;

    }

    public Category(int id, String name, String desc, List<Product> product) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.product = product;
    }

    public Category() {
    }

    public Category(String name, String desc) {
        this.name = name;
        this.desc=desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        desc = desc;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", product=" + product +
                '}';
    }
}
