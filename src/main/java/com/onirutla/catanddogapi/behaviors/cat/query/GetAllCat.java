package com.onirutla.catanddogapi.behaviors.cat.query;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class GetAllCat implements BaseCommand<List<Cat>> {

    private final CatRepository repository;
    private final Pageable pageable;

    public GetAllCat(@Autowired CatRepository repository, Pageable pageable) {
        this.repository = repository;
        this.pageable = pageable;
    }

    @Override
    public List<Cat> execute(Optional<List<Cat>> param) {
        return repository.findCatByIsDeletedIsFalseOrderById(pageable);
    }
}
