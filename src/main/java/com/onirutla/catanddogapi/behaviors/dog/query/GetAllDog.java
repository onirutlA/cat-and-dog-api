package com.onirutla.catanddogapi.behaviors.dog.query;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Dog;
import com.onirutla.catanddogapi.presentation.response.DogDTO;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class GetAllDog implements BaseCommand<List<DogDTO>> {

    private final DogRepository repository;
    private final Pageable pageable;

    public GetAllDog(@Autowired DogRepository repository, Pageable pageable) {
        this.repository = repository;
        this.pageable = pageable;
    }

    @Override
    public List<DogDTO> execute(Optional<List<DogDTO>> param) {
        Page<Dog> dogs = repository.findAll(pageable);

        return dogs.map(dog -> new DogDTO(
                dog.getId(),
                dog.getName(),
                dog.getType(),
                dog.getColor(),
                dog.getHeight())
        ).toList();
    }
}
