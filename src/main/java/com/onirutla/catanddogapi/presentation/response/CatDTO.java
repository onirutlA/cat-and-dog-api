package com.onirutla.catanddogapi.presentation.response;

import com.onirutla.catanddogapi.model.Cat;

public class CatDTO {

    private String name;

    private String type;

    private String color;

    private Double height;

    public CatDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Cat toCat() {
        Cat cat = new Cat();
        cat.setName(this.getName());
        cat.setType(this.getType());
        cat.setColor(this.getColor());
        cat.setHeight(this.getHeight());
        return cat;
    }
}
