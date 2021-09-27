package com.onirutla.catanddogapi.presentation.response;

import com.onirutla.catanddogapi.model.Cat;

public class CatDTO {

    private Integer id;

    private String name;

    private String type;

    private String color;

    private Double height;

    private Boolean isDeleted = false;

    public CatDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Cat toCat() {
        Cat cat = new Cat();
        cat.setName(this.getName());
        cat.setType(this.getType());
        cat.setColor(this.getColor());
        cat.setHeight(this.getHeight());
        cat.setIsDeleted(this.getDeleted());
        return cat;
    }
}
