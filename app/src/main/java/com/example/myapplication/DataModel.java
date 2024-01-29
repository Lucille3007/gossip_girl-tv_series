package com.example.myapplication;

public class DataModel {

    private String name;
    private String description;
    private int id;
    private int image;

    public DataModel(String name, String description, int id, int image) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
