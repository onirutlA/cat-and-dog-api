package com.onirutla.catanddogapi.application.behaviors;

import java.util.Optional;

public interface BaseCommand<T> {
    T execute(Optional<T> param);
}
