package com.onirutla.catanddogapi.application.behaviors.dog.command;

import com.onirutla.catanddogapi.application.behaviors.BaseCommand;
import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;

import java.util.Optional;

public class UpdateDog implements BaseCommand<Dog> {

    private final DogRepository repository;
    private final Integer existingId;

    public UpdateDog(DogRepository repository, Integer existingId) {
        this.repository = repository;
        this.existingId = existingId;
    }

    @Override
    public Dog execute(Optional<Dog> param) {
        return repository.findById(existingId).map(dog -> {
            dog.setName(param.get().getName());
            dog.setType(param.get().getType());
            dog.setColor(param.get().getColor());
            dog.setHeight(param.get().getHeight());
            return repository.save(dog);
        }).orElseGet(Dog::new);
    }
}
