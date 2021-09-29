package com.onirutla.catanddogapi.behaviors.cat.command;

import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class UpdateCatTests {

    @Mock
    private CatRepository catRepository;

    private Cat existingCat;

    private Cat newCat;

    private UpdateCat updateCat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        existingCat = new Cat();
        existingCat.setId(1);
        existingCat.setName("testName");
        existingCat.setType("testType");
        existingCat.setColor("testColor");
        existingCat.setHeight(2.0);

        newCat = new Cat();
        newCat.setId(1);
        newCat.setName("name");
        newCat.setType("type");
        newCat.setColor("color");
        newCat.setHeight(2.1);

        updateCat = new UpdateCat(catRepository, existingCat.getId());
    }

    @Test
    void UpdateCat_WithFullData_ShouldReturnSuccess() {
        // Arrange
        when(catRepository.findById(existingCat.getId())).thenReturn(Optional.of(existingCat));
        when(catRepository.save(newCat)).thenReturn(newCat);

        // Act
        Cat expectedResult = updateCat.execute(Optional.ofNullable(newCat));

        // Assert
        Assert.notNull(expectedResult, "should not null");
        Assert.notNull(expectedResult.getName(), "name should not null");
        Assert.notNull(expectedResult.getType(), "type should not null");
        Assert.notNull(expectedResult.getColor(), "color should not null");
        Assert.notNull(expectedResult.getHeight(), "height should not null");

        Assert.isTrue(Objects.equals(expectedResult.getId(), existingCat.getId()), "updated cat id should be the same as existing cat id");
        Assert.isTrue(expectedResult.getName().equalsIgnoreCase(existingCat.getName()), "updated name should be the same as existing cat name");
        Assert.isTrue(expectedResult.getType().equalsIgnoreCase(existingCat.getType()), "updated type should be the same as existing cat type");
        Assert.isTrue(expectedResult.getColor().equalsIgnoreCase(existingCat.getColor()), "updated color should be the same as existing cat color");
        Assert.isTrue(Objects.equals(expectedResult.getHeight(), existingCat.getHeight()), "updated height should be the same as existing cat height");

        verify(catRepository, times(1)).findById(existingCat.getId());
        verify(catRepository, times(1)).save(existingCat);
    }
}
