package com.onirutla.catanddogapi.behaviors.cat.command;

import com.onirutla.catanddogapi.model.Cat;
import com.onirutla.catanddogapi.repository.CatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.mockito.Mockito.*;

class InsertCatTests {

    @Mock
    private CatRepository repository;

    private InsertCat insertCat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        insertCat = new InsertCat(repository);
    }

    @Test
    public void InsertCat_WithNullName_ShouldReturnFail() {
        // Arrange
        Cat cat = new Cat();
        cat.setType("testType");
        cat.setColor("testColor");
        cat.setHeight(2.0);

        when(repository.save(cat)).thenReturn(cat);

        // Act
        Cat expectedResult = insertCat.execute(Optional.of(cat));

        // Assert
        Assert.isNull(expectedResult.getName(), "name should be null");
        Assert.notNull(expectedResult.getType(), "type should NOT be null");
        Assert.notNull(expectedResult.getColor(), "color should NOT be null");
        Assert.notNull(expectedResult.getHeight(), "height should NOT be null");

        // Verify
        verify(repository, times(1)).save(cat);
    }

    @Test
    public void InsertCat_WithNullType_ShouldReturnFail() {
        // Arrange
        Cat cat = new Cat();
        cat.setName("testName");
        cat.setColor("testColor");
        cat.setHeight(2.0);

        when(repository.save(cat)).thenReturn(cat);

        // Act
        Cat expectedResult = insertCat.execute(Optional.of(cat));

        // Assert
        Assert.notNull(expectedResult.getName(), "name should NOT be null");
        Assert.isNull(expectedResult.getType(), "type should be null");
        Assert.notNull(expectedResult.getColor(), "color should NOT be null");
        Assert.notNull(expectedResult.getHeight(), "height should NOT be null");

        // Verify
        verify(repository, times(1)).save(cat);
    }

    @Test
    public void InsertCat_WithNullColor() {
        // Arrange
        Cat cat = new Cat();
        cat.setName("testName");
        cat.setType("testType");
        cat.setHeight(2.0);

        when(repository.save(cat)).thenReturn(cat);

        // Act
        Cat expectedResult = insertCat.execute(Optional.of(cat));

        // Assert
        Assert.notNull(expectedResult.getName(), "name should NOT be null");
        Assert.notNull(expectedResult.getType(), "type should NOT be null");
        Assert.isNull(expectedResult.getColor(), "color should be null");
        Assert.notNull(expectedResult.getHeight(), "height should NOT be null");

        // Verify
        verify(repository, times(1)).save(cat);
    }

    @Test
    public void InsertCat_WithNullHeight() {
        // Arrange
        Cat cat = new Cat();
        cat.setName("testName");
        cat.setType("testType");
        cat.setColor("testColor");

        when(repository.save(cat)).thenReturn(cat);

        // Act
        Cat expectedResult = insertCat.execute(Optional.of(cat));

        // Assert
        Assert.notNull(expectedResult.getName(), "name should NOT be null");
        Assert.notNull(expectedResult.getType(), "type should NOT be null");
        Assert.notNull(expectedResult.getColor(), "color should NOT be null");
        Assert.isNull(expectedResult.getHeight(), "height should be null");

        // Verify
        verify(repository, times(1)).save(cat);
    }

    @Test
    public void InsertCat_WithAllNull_ShouldReturnFail() {
        // Arrange
        Cat cat = new Cat();

        when(repository.save(cat)).thenReturn(cat);

        // Act
        Cat expectedResult = insertCat.execute(Optional.of(cat));

        // Assert
        Assert.isNull(expectedResult.getName(), "name should be null");
        Assert.isNull(expectedResult.getType(), "type should be null");
        Assert.isNull(expectedResult.getColor(), "color should be null");
        Assert.isNull(expectedResult.getHeight(), "height should be null");

        // Verify
        verify(repository, times(1)).save(cat);
    }

    @Test
    public void InsertCat_WithFullData_ShouldReturnSuccess() {
        // Arrange
        Cat cat = new Cat();
        cat.setName("testName");
        cat.setType("testType");
        cat.setColor("testColor");
        cat.setHeight(2.0);

        when(repository.save(cat)).thenReturn(cat);

        // Act
        Cat expectedResult = insertCat.execute(Optional.of(cat));

        // Assert
        Assert.notNull(expectedResult, "cat should not be null");
        Assert.isTrue(expectedResult.getName().equals(cat.getName()), "cat name should be the same");
        Assert.isTrue(expectedResult.getType().equals(cat.getType()), "cat type should be the same");
        Assert.isTrue(expectedResult.getColor().equals(cat.getColor()), "cat color should be the same");
        Assert.isTrue(expectedResult.getHeight().equals(cat.getHeight()), "cat height should be the same");

        // Verify
        verify(repository, times(1)).save(cat);
    }
}