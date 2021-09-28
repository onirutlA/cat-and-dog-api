package com.onirutla.catanddogapi.behaviors.cat.query;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.presentation.response.CatDTO;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class GetAllCat implements BaseCommand<List<CatDTO>> {

    private final CatRepository repository;
    private final Pageable pageable;

    public GetAllCat(@Autowired CatRepository repository, Pageable pageable) {
        this.repository = repository;
        this.pageable = pageable;
    }

    @Override
    public List<CatDTO> execute(Optional<List<CatDTO>> param) {
        Page<Cat> cats = repository.findAllByIsDeletedFalseOrderById(pageable);

        return cats.map(cat -> new CatDTO(
                cat.getId(),
                cat.getName(),
                cat.getType(),
                cat.getColor(),
                cat.getHeight())
        ).toList();
    }
}
