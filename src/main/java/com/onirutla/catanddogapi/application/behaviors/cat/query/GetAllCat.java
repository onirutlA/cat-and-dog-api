package com.onirutla.catanddogapi.application.behaviors.cat.query;

import com.onirutla.catanddogapi.application.behaviors.BaseCommand;
import com.onirutla.catanddogapi.application.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class GetAllCat implements BaseCommand<List<Cat>> {

    private final CatRepository repository;
    private final Pageable pageable;

    public GetAllCat(CatRepository repository, Pageable pageable) {
        this.repository = repository;
        this.pageable = pageable;
    }

    @Override
    public List<Cat> execute(Optional<List<Cat>> param) {
        return repository.findAllByIsDeletedFalseOrderById(pageable);
    }
}
