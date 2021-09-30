package com.onirutla.catanddogapi.application.behaviors.cat.command;

import com.onirutla.catanddogapi.application.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.mockito.Mockito.*;

class DeleteCatTest {

    @Mock
    private CatRepository catRepository;

    private DeleteCat deleteCat;

    private Cat existingCat;

    private Cat deletedCat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        existingCat = new Cat();
        existingCat.setId(1);
        existingCat.setIsDeleted(false);

        deletedCat = new Cat();
        deletedCat.setId(1);
        deletedCat.setIsDeleted(true);

        deleteCat = new DeleteCat(catRepository, existingCat.getId());
    }

    @Test
    void UpdateCat_WithFullData_ShouldReturnSuccess() {
        // Arrange
        when(catRepository.findById(existingCat.getId())).thenReturn(Optional.of(existingCat));
        when(catRepository.save(deletedCat)).thenReturn(deletedCat);

        // Act
        Cat expectedResult = deleteCat.execute(Optional.ofNullable(deletedCat));

        // Assert
        Assert.notNull(expectedResult, "should not null");
        Assert.notNull(expectedResult.getIsDeleted(), "should not null");
        Assert.isTrue(expectedResult.getIsDeleted(), "isDeleted expected should be true");
        Assert.isTrue(expectedResult.getIsDeleted().equals(existingCat.getIsDeleted()), "expected must be the same as existing");

        verify(catRepository, times(1)).findById(existingCat.getId());
        verify(catRepository, times(1)).save(existingCat);
    }
}