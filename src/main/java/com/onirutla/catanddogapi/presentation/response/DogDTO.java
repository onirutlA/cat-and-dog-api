package com.onirutla.catanddogapi.presentation.response;

import com.onirutla.catanddogapi.application.model.Dog;

public class DogDTO {

    private final Integer id;

    private final String name;

    private final String type;

    private final String color;

    private final Double height;

    public DogDTO(Integer id, String name, String type, String color, Double height) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public Double getHeight() {
        return height;
    }

    public Dog toDog() {
        Dog dog = new Dog();
        dog.setId(this.getId());
        dog.setName(this.getName());
        dog.setType(this.getType());
        dog.setColor(this.getColor());
        dog.setHeight(this.getHeight());
        dog.setIsDeleted(false);
        return dog;
    }
}
