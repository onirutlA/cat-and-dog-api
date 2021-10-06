package com.onirutla.catanddogapi.behaviors;

import java.util.Optional;

public interface BaseCommand<T> {
    T execute(Optional<T> param);
}
