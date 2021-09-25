package com.onirutla.catanddogapi.presentation.controller;

import com.onirutla.catanddogapi.behaviors.dog.command.InsertDog;
import com.onirutla.catanddogapi.behaviors.dog.query.GetAllDog;
import com.onirutla.catanddogapi.model.Dog;
import com.onirutla.catanddogapi.presentation.response.DogDTO;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {

    private final DogRepository repository;

    public DogController(@Autowired DogRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/dog")
    public List<DogDTO> getDogs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        GetAllDog command = new GetAllDog(repository, pageable);
        return command.execute(Optional.empty());
    }

    @PostMapping(path = "/dog")
    public Dog getDogs(@RequestBody DogDTO requestBody) {
        InsertDog command = new InsertDog(repository);
        return command.execute(Optional.of(requestBody.toDog()));
    }
}
