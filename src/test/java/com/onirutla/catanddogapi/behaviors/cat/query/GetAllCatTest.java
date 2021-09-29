package com.onirutla.catanddogapi.behaviors.cat.query;

import com.onirutla.catanddogapi.model.Cat;
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
    private CatRepository repository;

    private GetAllCat getAllCat;

    private final Pageable pageable = PageRequest.of(0, 10);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getAllCat = new GetAllCat(repository, pageable);
    }

    @Test
    public void GetAllCat_ShouldReturnSuccess() {
        // Arrange
        final List<Cat> cats = new ArrayList<>();
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
        when(repository.findCatByIsDeletedIsFalseOrderById(pageable)).thenReturn(cats);

        // Act
        List<Cat> expectedResult = getAllCat.execute(Optional.empty());

        // Assert
        Assert.notNull(expectedResult, "cat should not null");
        Assert.isTrue(expectedResult.size() > 0, "cat should not 0");
        Assert.isTrue(expectedResult.size() == cats.size(), "cat should be the same as input");

        // Verify
        verify(repository, times(1)).findCatByIsDeletedIsFalseOrderById(pageable);
    }

}