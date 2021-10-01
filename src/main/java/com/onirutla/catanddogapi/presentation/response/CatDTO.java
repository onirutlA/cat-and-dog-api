package com.onirutla.catanddogapi.presentation.response;

import com.onirutla.catanddogapi.application.model.Cat;

public class CatDTO {

    private final Integer id;

    private final String name;

    private final String type;

    private final String color;

    private final Double height;

    public CatDTO(Integer id, String name, String type, String color, Double height) {
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

    public Cat toCat() {
        Cat cat = new Cat();
        cat.setId(this.getId());
        cat.setName(this.getName());
        cat.setType(this.getType());
        cat.setColor(this.getColor());
        cat.setHeight(this.getHeight());
        cat.setIsDeleted(false);
        return cat;
    }
}
