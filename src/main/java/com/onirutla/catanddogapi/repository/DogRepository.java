package com.onirutla.catanddogapi.repository;

import com.onirutla.catanddogapi.model.Dog;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface DogRepository extends JpaRepository<Dog, String> {

    Page<Dog> findAll(Pageable pageable);



}
