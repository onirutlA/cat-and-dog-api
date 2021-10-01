package com.onirutla.catanddogapi.application.behaviors.cat.query;

import com.onirutla.catanddogapi.application.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class GetAllCatTest {

    @Mock
    private CatRepository catRepository;

    private GetAllCat getAllCat;

    private final Pageable pageable = PageRequest.of(0, 10);

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        getAllCat = new GetAllCat(catRepository, pageable);
    }

    @Test
    public void GetAllCat_ShouldReturnSuccess(){
        // Arrange
        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Cat cat = new Cat();
            cat.setId(i);
            cat.setName("testName");
            cat.setType("testType");
            cat.setColor("testColor");
            cat.setHeight(2.0);
            cat.setIsDeleted(false);
            cats.add(cat);
        }

        when(catRepository.findAllByIsDeletedFalseOrderById(pageable)).thenReturn(cats);

        // Act
        List<Cat> expectedResult = getAllCat.execute(Optional.empty());

        // Assert
        Assert.notNull(expectedResult, "expected should not be null");
        Assert.isTrue(expectedResult.size() > 0, "expected should be more than 0");
        Assert.isTrue(expectedResult.size() == cats.size(), "expected should be the same as cats");

        // Verify
        verify(catRepository, times(1)).findAllByIsDeletedFalseOrderById(pageable);
    }

}