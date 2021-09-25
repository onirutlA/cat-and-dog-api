package com.onirutla.catanddogapi.presentation.response;

import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.model.Dog;

public class DogDTO {

    private String name;

    private String type;

    private String color;

    private Double height;

    public DogDTO() {
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

    public Dog toDog() {
        Dog dog = new Dog();
        dog.setName(this.getName());
        dog.setType(this.getType());
        dog.setColor(this.getColor());
        dog.setHeight(this.getHeight());
        return dog;
    }



}
