package com.onirutla.catanddogapi.repository;

import java.util.List;
import java.util.Optional;

import com.onirutla.catanddogapi.model.Cat;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
    List<Cat> findAllByIsDeletedFalseOrderById(Pageable pageable);

    Optional<Cat> findById(Integer existingId);
}
