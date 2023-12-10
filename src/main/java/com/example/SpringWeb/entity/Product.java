package com.example.SpringWeb.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",columnDefinition = "NVARCHAR(100)")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="description",columnDefinition = "NVARCHAR(1000)")
    private String description;
    @Lob
    @Column(name="image" ,columnDefinition ="NVARCHAR(MAX)")
    private String image;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product() {
    }

    public Product(int id, String name, int price, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }
}
