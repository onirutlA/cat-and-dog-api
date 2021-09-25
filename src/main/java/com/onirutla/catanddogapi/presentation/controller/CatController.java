package com.onirutla.catanddogapi.presentation.controller;

import com.onirutla.catanddogapi.behaviors.cat.query.GetAllCat;
import com.onirutla.catanddogapi.behaviors.cat.command.InsertCat;
import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.presentation.response.CatDTO;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CatController {

    private final CatRepository repository;

    public CatController(@Autowired CatRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/cat")
    public List<CatDTO> getCats(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "page", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        GetAllCat command = new GetAllCat(repository, pageable);
        return command.execute(Optional.empty());
    }

    @PostMapping(path = "/cat")
    public Cat insertCat(
            @RequestBody CatDTO requestBody
    ) {
        InsertCat command = new InsertCat(repository);
        return command.execute(Optional.of(requestBody.toCat()));
    }
}