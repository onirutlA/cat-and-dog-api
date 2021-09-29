package com.onirutla.catanddogapi.repository;

import com.onirutla.catanddogapi.model.Cat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
    List<Cat> findAllByIsDeletedFalseOrderById(Pageable pageable);
}
