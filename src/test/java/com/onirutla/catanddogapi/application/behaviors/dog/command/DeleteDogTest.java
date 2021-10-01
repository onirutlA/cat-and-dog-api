package com.onirutla.catanddogapi.application.behaviors.dog.command;


import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.mockito.Mockito.*;

class DeleteDogTest {

    @Mock
    private DogRepository dogRepository;

    private DeleteDog deleteDog;

    private Dog existingDog;

    private Dog deletedDog;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        existingDog = new Dog();
        existingDog.setId(1);
        existingDog.setIsDeleted(false);

        deletedDog = new Dog();
        deletedDog.setId(1);
        deletedDog.setIsDeleted(true);

        deleteDog = new DeleteDog(dogRepository, existingDog.getId());
    }

    @Test
    void DeleteDog_WithFullData_ShouldReturnSuccess() {
        // Arrange
        when(dogRepository.findDogByIsDeletedIsFalseAndId(existingDog.getId())).thenReturn(Optional.of(existingDog));
        when(dogRepository.save(deletedDog)).thenReturn(deletedDog);

        // Act
        Dog expectedResult = deleteDog.execute(Optional.ofNullable(deletedDog));

        // Assert
        Assert.notNull(expectedResult, "should not null");
        Assert.notNull(expectedResult.getIsDeleted(), "should not null");
        Assert.isTrue(expectedResult.getIsDeleted(), "isDeleted expected should be true");
        Assert.isTrue(expectedResult.getIsDeleted().equals(existingDog.getIsDeleted()), "expected must be the same as existing");

        verify(dogRepository, times(1)).findDogByIsDeletedIsFalseAndId(existingDog.getId());
        verify(dogRepository, times(1)).save(existingDog);
    }
}