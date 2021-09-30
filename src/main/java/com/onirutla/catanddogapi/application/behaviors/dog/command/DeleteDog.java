package com.onirutla.catanddogapi.application.behaviors.dog.command;

import com.onirutla.catanddogapi.application.behaviors.BaseCommand;
import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;

import java.util.Optional;

public class DeleteDog implements BaseCommand<Dog> {

    private final DogRepository repository;
    private final Integer existingId;

    public DeleteDog(DogRepository repository, Integer existingId) {
        this.repository = repository;
        this.existingId = existingId;
    }

    @Override
    public Dog execute(Optional<Dog> param) {
        return repository.findDogByIsDeletedIsFalseAndId(existingId).map(dog -> {
            dog.setIsDeleted(true);
            return repository.save(dog);
        }).orElseThrow();
    }
}
