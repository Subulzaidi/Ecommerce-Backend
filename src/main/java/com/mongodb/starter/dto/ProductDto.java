package com.mongodb.starter.dto;

public class ProductDto {
    private long id;
    private String name;
    private String pdesc;
    private String imageUrl;
    private int price;
    private int discount;
    private int quantity;
    private Integer CategoryId;

    public ProductDto() {
    }

    public ProductDto(long id, String name, String pdesc, String imageUrl, int price, int discount, int quantity, Integer CategoryId) {
        this.id = id;
        this.name=name;
        this.pdesc = pdesc;
        this.imageUrl = imageUrl;
        this.price = price;
        this.discount = discount;
        this.CategoryId=CategoryId;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
