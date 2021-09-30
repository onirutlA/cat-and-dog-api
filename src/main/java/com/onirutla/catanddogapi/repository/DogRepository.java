package com.onirutla.catanddogapi.repository;

import com.onirutla.catanddogapi.application.model.Dog;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface DogRepository extends JpaRepository<Dog, Integer> {
    List<Dog> findAllByIsDeletedFalseOrderById(Pageable pageable);
    Optional<Dog> findDogByIsDeletedIsFalseAndId(Integer existingId);
    Optional<Dog> findById(Integer existingId);
}
