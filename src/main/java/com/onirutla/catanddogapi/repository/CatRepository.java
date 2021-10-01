package com.onirutla.catanddogapi.repository;

import com.onirutla.catanddogapi.application.model.Cat;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface CatRepository extends JpaRepository<Cat, Integer> {
    List<Cat> findAllByIsDeletedFalseOrderById(Pageable pageable);
    Optional<Cat> findCatByIsDeletedIsFalseAndId(Integer id);
    Optional<Cat> findById(Integer existingId);
}
