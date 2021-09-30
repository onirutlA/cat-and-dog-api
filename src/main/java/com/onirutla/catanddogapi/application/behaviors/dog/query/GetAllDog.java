package com.onirutla.catanddogapi.application.behaviors.dog.query;

import com.onirutla.catanddogapi.application.behaviors.BaseCommand;
import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class GetAllDog implements BaseCommand<Page<Dog>> {

    private final DogRepository repository;
    private final Pageable pageable;

    public GetAllDog(DogRepository repository, Pageable pageable) {
        this.repository = repository;
        this.pageable = pageable;
    }

    @Override
    public Page<Dog> execute(Optional<Page<Dog>> param) {
        return repository.findAll(pageable);
    }
}
