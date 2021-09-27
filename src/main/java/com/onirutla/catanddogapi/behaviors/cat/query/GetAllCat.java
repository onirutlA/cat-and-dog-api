package com.onirutla.catanddogapi.behaviors.cat.query;

import com.onirutla.catanddogapi.behaviors.BaseCommand;
import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.presentation.response.CatDTO;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
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
        List<CatDTO> responseHolder = new ArrayList<>();

        for (Cat cat : cats) {
            CatDTO catDTO = new CatDTO();
            catDTO.setId(cat.getId());
            catDTO.setName(cat.getName());
            catDTO.setType(cat.getType());
            catDTO.setColor(cat.getColor());
            catDTO.setHeight(cat.getHeight());
            responseHolder.add(catDTO);
        }

        return responseHolder;
    }
}
