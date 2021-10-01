package com.onirutla.catanddogapi.application.behaviors.cat.command;

import com.onirutla.catanddogapi.application.behaviors.BaseCommand;
import com.onirutla.catanddogapi.application.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;

import java.util.Optional;

public class DeleteCat implements BaseCommand<Cat> {

    private final CatRepository repository;
    private final Integer existingId;

    public DeleteCat(CatRepository repository, Integer existingId) {
        this.repository = repository;
        this.existingId = existingId;
    }

    @Override
    public Cat execute(Optional<Cat> param) {
        return repository.findById(existingId).map(cat -> {
            cat.setIsDeleted(true);
            return repository.save(cat);
        }).orElseThrow();
    }
}
