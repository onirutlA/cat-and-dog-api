package com.onirutla.catanddogapi.behaviors.dog.query;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Dog;
import com.onirutla.catanddogapi.presentation.response.DogDTO;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
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
        List<DogDTO> responseHolder = new ArrayList<>();

        for (Dog dog : dogs) {
            DogDTO dogDTO = new DogDTO();
            dogDTO.setName(dog.getName());
            dogDTO.setType(dog.getType());
            dogDTO.setColor(dog.getColor());
            dogDTO.setHeight(dog.getHeight());
            responseHolder.add(dogDTO);
        }

        return responseHolder;
    }



}
