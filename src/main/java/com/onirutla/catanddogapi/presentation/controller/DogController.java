package com.onirutla.catanddogapi.presentation.controller;

import com.onirutla.catanddogapi.behaviors.dog.command.DeleteDog;
import com.onirutla.catanddogapi.behaviors.dog.command.InsertDog;
import com.onirutla.catanddogapi.behaviors.dog.command.UpdateDog;
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
import java.util.stream.Collectors;

@RestController
public class DogController {

    private final DogRepository repository;

    public DogController(@Autowired DogRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/dog")
    public List<DogDTO> getDogs(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        GetAllDog command = new GetAllDog(repository, pageable);
        List<Dog> response = command.execute(Optional.empty()).getContent();
        return response
                .stream()
                .map(dog -> new DogDTO(
                        dog.getId(),
                        dog.getName(),
                        dog.getType(),
                        dog.getColor(),
                        dog.getHeight()
                )).collect(Collectors.toUnmodifiableList());
    }

    @PostMapping(path = "/dog")
    public Dog insertDog(@RequestBody DogDTO requestBody) {
        InsertDog command = new InsertDog(repository);
        return command.execute(Optional.of(requestBody.toDog()));
    }

    @PutMapping(path = "/dog/{id}")
    public Dog updateDog(@PathVariable Integer id, @RequestBody DogDTO requestBody) {
        UpdateDog command = new UpdateDog(repository, id);
        return command.execute(Optional.ofNullable(requestBody.toDog()));
    }

    @DeleteMapping(path = "/dog/{id}")
    public Dog deleteDog(@PathVariable Integer id) {
        DeleteDog command = new DeleteDog(repository, id);
        return command.execute(Optional.empty());
    }
}
