package com.onirutla.catanddogapi.behaviors.dog.command;

import com.onirutla.catanddogapi.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.mockito.Mockito.*;

class InsertDogTest {

    @Mock
    private DogRepository dogRepository;

    private InsertDog insertDog;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        insertDog = new InsertDog(dogRepository);
    }

    @Test
    public void InsertDog_WithNullName_ShouldReturnFail() {
        // Arrange
        Dog dog = new Dog();
        dog.setType("testType");
        dog.setColor("testColor");
        dog.setHeight(2.0);

        when(dogRepository.save(dog)).thenReturn(dog);

        // Act
        Dog expectedResult = insertDog.execute(Optional.of(dog));

        // Assert
        Assert.isNull(expectedResult.getName(), "name should be null");
        Assert.notNull(expectedResult.getType(), "type should NOT be null");
        Assert.notNull(expectedResult.getColor(), "color should NOT be null");
        Assert.notNull(expectedResult.getHeight(), "height should NOT be null");

        // Verify
        verify(dogRepository, times(1)).save(dog);
    }

    @Test
    public void InsertDog_WithNullType_ShouldReturnFail() {
        // Arrange
        Dog dog = new Dog();
        dog.setName("testName");
        dog.setColor("testColor");
        dog.setHeight(2.0);

        when(dogRepository.save(dog)).thenReturn(dog);

        // Act
        Dog expectedResult = insertDog.execute(Optional.of(dog));

        // Assert
        Assert.notNull(expectedResult.getName(), "name should NOT be null");
        Assert.isNull(expectedResult.getType(), "type should be null");
        Assert.notNull(expectedResult.getColor(), "color should NOT be null");
        Assert.notNull(expectedResult.getHeight(), "height should NOT be null");

        // Verify
        verify(dogRepository, times(1)).save(dog);
    }

    @Test
    public void InsertDog_WithNullColor() {
        // Arrange
        Dog dog = new Dog();
        dog.setName("testName");
        dog.setType("testType");
        dog.setHeight(2.0);

        when(dogRepository.save(dog)).thenReturn(dog);

        // Act
        Dog expectedResult = insertDog.execute(Optional.of(dog));

        // Assert
        Assert.notNull(expectedResult.getName(), "name should NOT be null");
        Assert.notNull(expectedResult.getType(), "type should NOT be null");
        Assert.isNull(expectedResult.getColor(), "color should be null");
        Assert.notNull(expectedResult.getHeight(), "height should NOT be null");

        // Verify
        verify(dogRepository, times(1)).save(dog);
    }

    @Test
    public void InsertDog_WithNullHeight() {
        // Arrange
        Dog dog = new Dog();
        dog.setName("testName");
        dog.setType("testType");
        dog.setColor("testColor");

        when(dogRepository.save(dog)).thenReturn(dog);

        // Act
        Dog expectedResult = insertDog.execute(Optional.of(dog));

        // Assert
        Assert.notNull(expectedResult.getName(), "name should NOT be null");
        Assert.notNull(expectedResult.getType(), "type should NOT be null");
        Assert.notNull(expectedResult.getColor(), "color should NOT be null");
        Assert.isNull(expectedResult.getHeight(), "height should be null");

        // Verify
        verify(dogRepository, times(1)).save(dog);
    }

    @Test
    public void InsertDog_WithAllNull_ShouldReturnFail() {
        // Arrange
        Dog dog = new Dog();

        when(dogRepository.save(dog)).thenReturn(dog);

        // Act
        Dog expectedResult = insertDog.execute(Optional.of(dog));

        // Assert
        Assert.isNull(expectedResult.getName(), "name should be null");
        Assert.isNull(expectedResult.getType(), "type should be null");
        Assert.isNull(expectedResult.getColor(), "color should be null");
        Assert.isNull(expectedResult.getHeight(), "height should be null");

        // Verify
        verify(dogRepository, times(1)).save(dog);
    }

    @Test
    public void InsertDog_WithFullData_ShouldReturnSuccess() {
        // Arrange
        Dog dog = new Dog();
        dog.setName("testName");
        dog.setType("testType");
        dog.setColor("testColor");
        dog.setHeight(2.0);

        when(dogRepository.save(dog)).thenReturn(dog);

        // Act
        Dog expectedResult = insertDog.execute(Optional.of(dog));

        // Assert
        Assert.notNull(expectedResult, "dog should not be null");
        Assert.isTrue(expectedResult.getName().equals(dog.getName()), "dog name should be the same");
        Assert.isTrue(expectedResult.getType().equals(dog.getType()), "dog type should be the same");
        Assert.isTrue(expectedResult.getColor().equals(dog.getColor()), "dog color should be the same");
        Assert.isTrue(expectedResult.getHeight().equals(dog.getHeight()), "dog height should be the same");

        // Verify
        verify(dogRepository, times(1)).save(dog);
    }
}