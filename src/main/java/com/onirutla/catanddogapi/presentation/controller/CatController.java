package com.onirutla.catanddogapi.presentation.controller;

import com.onirutla.catanddogapi.application.behaviors.cat.command.DeleteCat;
import com.onirutla.catanddogapi.application.behaviors.cat.command.InsertCat;
import com.onirutla.catanddogapi.application.behaviors.cat.command.UpdateCat;
import com.onirutla.catanddogapi.application.behaviors.cat.query.GetAllCat;
import com.onirutla.catanddogapi.application.model.Cat;
import com.onirutla.catanddogapi.presentation.BaseResponse;
import com.onirutla.catanddogapi.presentation.response.CatDTO;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CatController {

    private final CatRepository repository;

    public CatController(CatRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/cat")
    public BaseResponse<List<CatDTO>> getCats(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        GetAllCat command = new GetAllCat(repository, pageable);
        List<CatDTO> dtos = command.execute(Optional.empty())
                .stream()
                .map(cat -> new CatDTO(
                        cat.getId(),
                        cat.getName(),
                        cat.getType(),
                        cat.getColor(),
                        cat.getHeight()
                )).collect(Collectors.toUnmodifiableList());

        BaseResponse<List<CatDTO>> response = new BaseResponse<>();
        response.setResult(dtos);
        response.setStatusCode(HttpStatus.OK.toString());
        response.setMessage("Successfull length: " + dtos.size());

        return response;
    }

    @PostMapping(path = "/cat")
    public BaseResponse<CatDTO> insertCat(@RequestBody CatDTO requestBody) {
        InsertCat command = new InsertCat(repository);
        Cat cat = command.execute(Optional.of(requestBody.toCat()));
        CatDTO dto = new CatDTO(cat.getId(), cat.getName(), cat.getType(), cat.getColor(), cat.getHeight());

        BaseResponse<CatDTO> response = new BaseResponse<>();
        response.setResult(dto);
        response.setStatusCode(HttpStatus.CREATED.toString());
        response.setMessage("Cat is successfully inserted");

        return response;
    }

    @PutMapping(path = "/cat/{id}")
    public BaseResponse<Void> updateCat(@PathVariable Integer id, @RequestBody CatDTO requestBody) {
        UpdateCat command = new UpdateCat(repository, id);
        command.execute(Optional.of(requestBody.toCat()));

        BaseResponse<Void> response = new BaseResponse<>();
        response.setMessage("Cat is successfully updated");
        response.setStatusCode(HttpStatus.OK.toString());

        return response;
    }

    @DeleteMapping(path = "cat/{id}")
    public BaseResponse<Void> deleteCat(@PathVariable Integer id) {
        DeleteCat command = new DeleteCat(repository, id);
        command.execute(Optional.empty());

        BaseResponse<Void> response = new BaseResponse<>();
        response.setMessage("Cat is successfully deleted");
        response.setStatusCode(HttpStatus.OK.toString());

        return response;
    }
}
