package com.onirutla.catanddogapi.application.behaviors.dog.query;

import com.onirutla.catanddogapi.application.behaviors.BaseCommand;
import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class GetAllDog implements BaseCommand<List<Dog>> {

    private final DogRepository repository;
    private final Pageable pageable;

    public GetAllDog(DogRepository repository, Pageable pageable) {
        this.repository = repository;
        this.pageable = pageable;
    }

    @Override
    public List<Dog> execute(Optional<List<Dog>> param) {
        return repository.findAllByIsDeletedFalseOrderById(pageable);
    }
}
