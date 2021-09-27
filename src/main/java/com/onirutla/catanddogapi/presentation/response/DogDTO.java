package com.onirutla.catanddogapi.presentation.response;

import com.onirutla.catanddogapi.model.Dog;

public class DogDTO {

    private String name;

    private String type;

    private String color;

    private Double height;

    private Boolean isDeleted;

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

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Dog toDog() {
        Dog dog = new Dog();
        dog.setName(this.name);
        dog.setType(this.type);
        dog.setColor(this.color);
        dog.setHeight(this.height);
        dog.setIsDeleted(this.isDeleted);
        return dog;
    }


}
