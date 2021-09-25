package com.onirutla.catanddogapi.behaviors.cat.command;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;

import java.util.Optional;

public class InsertCat implements BaseCommand<Cat> {

    private final CatRepository repository;

    public InsertCat(CatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cat execute(Optional<Cat> param) {
        return repository.save(param.orElseThrow());
    }
}
