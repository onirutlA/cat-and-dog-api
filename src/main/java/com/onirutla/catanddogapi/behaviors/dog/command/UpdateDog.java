package com.onirutla.catanddogapi.behaviors.dog.command;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UpdateDog implements BaseCommand<Dog> {

    private final DogRepository repository;
    private final Integer existingId;

    public UpdateDog(@Autowired DogRepository repository, Integer existingId) {
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
