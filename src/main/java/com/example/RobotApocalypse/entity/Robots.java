package com.example.RobotApocalypse.entity;

public class Robots {
    private String model;
    private String category;

    public Robots() {
    }

    public Robots(String model, String category) {
        this.model = model;
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
