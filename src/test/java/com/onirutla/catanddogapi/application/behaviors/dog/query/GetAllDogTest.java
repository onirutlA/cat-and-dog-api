package com.onirutla.catanddogapi.application.behaviors.dog.query;

import com.onirutla.catanddogapi.application.model.Dog;
import com.onirutla.catanddogapi.repository.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class GetAllDogTest {

    @Mock
    private DogRepository repository;

    private GetAllDog getAllDog;

    private final List<Dog> dogs = new ArrayList<>();

    private final Pageable pageable = PageRequest.of(0, 10);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getAllDog = new GetAllDog(repository, pageable);

        for (int i = 0; i < 10; i++) {
            Dog dog = new Dog();
            dog.setId(i);
            dog.setName("testName");
            dog.setType("testType");
            dog.setColor("testColor");
            dog.setHeight(2.0);
            dogs.add(dog);
        }
    }

    @Test
    public void GetAllDogs_ShouldReturnSuccess(){
        // Arrange
        when(repository.findAllByIsDeletedFalseOrderById(pageable)).thenReturn(dogs);

        // Act
        List<Dog> expectedResult = getAllDog.execute(Optional.empty());

        // Assert
        Assert.notNull(expectedResult, "should not be null");
        Assert.isTrue(expectedResult.size() > 0, "dog should be more than 0");
        Assert.isTrue(expectedResult.size() == dogs.size(), "expected size should be the same as dogs");

        // Verify
        verify(repository, times(1)).findAllByIsDeletedFalseOrderById(pageable);
    }
}