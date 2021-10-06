package com.onirutla.catanddogapi.behaviors.dog.command;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class InsertDog implements BaseCommand<Dog> {

    private final DogRepository repository;

    public InsertDog(@Autowired DogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dog execute(Optional<Dog> param) {
        return repository.save(param.orElseThrow());
    }
}
