package com.mongodb.starter.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
public class Product {
    private String id;
    private String Desc;
    private String imageUrl;
    private int price;
    private int discount;


    public Product(String id,String Desc,int price,String imageUrl) {
        this.id = id;
        this.Desc=Desc;
        this.price=price;
        this.imageUrl=imageUrl;

    }

    public Product(String id, String desc, String imageUrl, int price, int discount) {
        this.id = id;
        Desc = desc;
        this.imageUrl = imageUrl;
        this.price = price;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
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
}
