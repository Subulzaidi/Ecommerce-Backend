package com.mongodb.starter.models;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Product")
public class Product {

@MongoId
    private long id;
    private String name;
    private String desc;
    private String imageUrl;
    private int price;
    private int discount;
    private int quantity;
    @DBRef
    private Category category;

    public Product() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(long id, String name, String desc, int price, String imageUrl, int quantity, Category category) {
        this.id = id;
        this.name=name;
        this.category=category;
        this.quantity =quantity;
        this.desc = desc;
        this.price=price;
        this.imageUrl=imageUrl;

    }
    public Product(long id, String name, String desc, String imageUrl, int price, int discount, int quantity, Category category) {
        this.id = id;
        this.name=name;
        this.category=category;
        this.quantity=quantity;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}
