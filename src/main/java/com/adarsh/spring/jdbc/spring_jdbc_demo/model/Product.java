package com.adarsh.spring.jdbc.spring_jdbc_demo.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
    int id;
    String title;
    String description;

    int price;

    public Product(int id, String title, String description,int price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price=price;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice(){
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(int price){
        this.price=price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
