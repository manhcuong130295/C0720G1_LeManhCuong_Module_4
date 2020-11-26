package com.codegym.model;

public class Product {
    int id;
    String productCode;
    String productName;
    int price;
    String category;
    int unit;

    public Product() {
    }

    public Product(int id, String productCode, String productName, int price, String category, int unit) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
