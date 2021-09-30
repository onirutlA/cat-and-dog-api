package com.onirutla.catanddogapi.application.behaviors.cat.command;

import com.onirutla.catanddogapi.application.behaviors.BaseCommand;
import com.onirutla.catanddogapi.application.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;

import java.util.Optional;

public class UpdateCat implements BaseCommand<Cat> {

    private final CatRepository repository;
    private final Integer existingId;

    public UpdateCat(CatRepository repository, Integer existingId) {
        this.repository = repository;
        this.existingId = existingId;
    }

    @Override
    public Cat execute(Optional<Cat> param) {
        return repository.findById(existingId).map(cat -> {
            cat.setName(param.get().getName());
            cat.setType(param.get().getType());
            cat.setColor(param.get().getColor());
            cat.setHeight(param.get().getHeight());
            return repository.save(cat);
        }).orElseGet(Cat::new);
    }
}
