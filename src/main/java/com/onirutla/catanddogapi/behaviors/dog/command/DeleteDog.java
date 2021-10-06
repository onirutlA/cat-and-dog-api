package com.onirutla.catanddogapi.behaviors.dog.command;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DeleteDog implements BaseCommand<Dog> {

    private final DogRepository repository;
    private final Integer existingId;

    public DeleteDog(@Autowired DogRepository repository, Integer existingId) {
        this.repository = repository;
        this.existingId = existingId;
    }

    @Override
    public Dog execute(Optional<Dog> param) {
        return repository.findById(existingId).map(dog -> {
            dog.setIsDeleted(true);
            return repository.save(dog);
        }).orElseThrow();
    }
}
