package com.onirutla.catanddogapi.presentation.controller;

import com.onirutla.catanddogapi.application.behaviors.dog.command.DeleteDog;
import com.onirutla.catanddogapi.application.behaviors.dog.command.InsertDog;
import com.onirutla.catanddogapi.application.behaviors.dog.command.UpdateDog;
import com.onirutla.catanddogapi.application.behaviors.dog.query.GetAllDog;
import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.presentation.BaseResponse;
import com.onirutla.catanddogapi.presentation.response.DogDTO;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DogController {

    private final DogRepository repository;

    public DogController(DogRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/dog")
    public BaseResponse<List<DogDTO>> getDogs(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        GetAllDog command = new GetAllDog(repository, pageable);

        List<DogDTO> dtos = command.execute(Optional.empty()).stream()
                .map(dog -> new DogDTO(
                        dog.getId(),
                        dog.getName(),
                        dog.getType(),
                        dog.getColor(),
                        dog.getHeight()
                )).collect(Collectors.toUnmodifiableList());

        BaseResponse<List<DogDTO>> response = new BaseResponse<>();
        response.setResult(dtos);
        response.setStatusCode(HttpStatus.OK.toString());
        response.setMessage("Successfull length: " + dtos.size());

        return response;
    }

    @PostMapping(path = "/dog")
    public BaseResponse<DogDTO> insertDog(@RequestBody DogDTO requestBody) {
        InsertDog command = new InsertDog(repository);
        Dog dog = command.execute(Optional.of(requestBody.toDog()));
        DogDTO dto = new DogDTO(dog.getId(), dog.getName(), dog.getType(), dog.getColor(), dog.getHeight());

        BaseResponse<DogDTO> response = new BaseResponse<>();
        response.setResult(dto);
        response.setStatusCode(HttpStatus.CREATED.toString());
        response.setMessage("Dog is successfully inserted");

        return response;
    }

    @PutMapping(path = "/dog/{id}")
    public BaseResponse<Void> updateDog(@PathVariable Integer id, @RequestBody DogDTO requestBody) {
        UpdateDog command = new UpdateDog(repository, id);
        command.execute(Optional.ofNullable(requestBody.toDog()));

        BaseResponse<Void> response = new BaseResponse<>();
        response.setStatusCode(HttpStatus.OK.toString());
        response.setMessage("Dog is sucessfully updated");

        return response;
    }

    @DeleteMapping(path = "/dog/{id}")
    public BaseResponse<Void> deleteDog(@PathVariable Integer id) {
        DeleteDog command = new DeleteDog(repository, id);
        command.execute(Optional.empty());

        BaseResponse<Void> response = new BaseResponse<>();
        response.setStatusCode(HttpStatus.OK.toString());
        response.setMessage("Dog is sucessfully updated");

        return response;
    }
}
