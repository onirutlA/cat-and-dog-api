package com.onirutla.catanddogapi.application.behaviors.dog.command;


import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.*;

class UpdateDogTest {

    @Mock
    private DogRepository dogRepository;

    private UpdateDog updateDog;

    private Dog existingDog;

    private Dog newDog;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        existingDog = new Dog();
        existingDog.setId(1);
        existingDog.setName("testName");
        existingDog.setType("testType");
        existingDog.setColor("testColor");
        existingDog.setHeight(2.0);

        newDog = new Dog();
        newDog.setId(1);
        newDog.setName("name");
        newDog.setType("type");
        newDog.setColor("color");
        newDog.setHeight(2.1);

        updateDog = new UpdateDog(dogRepository, existingDog.getId());
    }

    @Test
    void UpdateDog_WithFullData_ShouldReturnSuccess() {
        // Arrange
        when(dogRepository.findById(existingDog.getId())).thenReturn(Optional.of(existingDog));
        when(dogRepository.save(newDog)).thenReturn(newDog);

        // Act
        Dog expectedResult = updateDog.execute(Optional.ofNullable(newDog));

        // Assert
        Assert.notNull(expectedResult, "should not null");
        Assert.notNull(expectedResult.getName(), "name should not null");
        Assert.notNull(expectedResult.getType(), "type should not null");
        Assert.notNull(expectedResult.getColor(), "color should not null");
        Assert.notNull(expectedResult.getHeight(), "height should not null");

        Assert.isTrue(Objects.equals(expectedResult.getId(), existingDog.getId()), "updated cat id should be the same as existing cat id");
        Assert.isTrue(expectedResult.getName().equalsIgnoreCase(existingDog.getName()), "updated name should be the same as existing cat name");
        Assert.isTrue(expectedResult.getType().equalsIgnoreCase(existingDog.getType()), "updated type should be the same as existing cat type");
        Assert.isTrue(expectedResult.getColor().equalsIgnoreCase(existingDog.getColor()), "updated color should be the same as existing cat color");
        Assert.isTrue(Objects.equals(expectedResult.getHeight(), existingDog.getHeight()), "updated height should be the same as existing cat height");

        verify(dogRepository, times(1)).findById(existingDog.getId());
        verify(dogRepository, times(1)).save(existingDog);
    }
}