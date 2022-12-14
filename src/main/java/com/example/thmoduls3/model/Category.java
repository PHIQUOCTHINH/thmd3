package com.example.thmoduls3.model;

public class Category {
    private int id_category;
    private String category;

    public Category() {
    }

    public Category(int id_category, String category) {
        this.id_category = id_category;
        this.category = category;
    }

    public Category(String category) {
        this.category = category;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id_category=" + id_category +
                ", category='" + category + '\'' +
                '}';
    }
}
