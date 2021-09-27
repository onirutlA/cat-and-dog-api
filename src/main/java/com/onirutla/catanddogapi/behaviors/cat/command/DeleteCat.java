package com.onirutla.catanddogapi.behaviors.cat.command;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DeleteCat implements BaseCommand<Cat> {

    private final CatRepository repository;
    private final Integer existingId;

    public DeleteCat(@Autowired CatRepository repository, Integer existingId) {
        this.repository = repository;
        this.existingId = existingId;
    }

    @Override
    public Cat execute(Optional<Cat> param) {
        return repository.findById(existingId).map(cat -> {
            cat.setIsDeleted(true);
            return cat;
        }).orElseThrow();
    }
}
