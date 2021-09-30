package com.onirutla.catanddogapi.application.behaviors.dog.command;

import com.onirutla.catanddogapi.application.behaviors.BaseCommand;
import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;

import java.util.Optional;

public class InsertDog implements BaseCommand<Dog> {

    private final DogRepository repository;

    public InsertDog(DogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dog execute(Optional<Dog> param) {
        return repository.save(param.orElseThrow());
    }
}
