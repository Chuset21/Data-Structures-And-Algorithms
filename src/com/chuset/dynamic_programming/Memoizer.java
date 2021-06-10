package com.chuset.dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Memoizer<T, U> {

    private final Map<T, U> cache = new HashMap<>();

    private Memoizer() {}

    private Function<T, U> doMemoize(final Function<T, U> function) {
        return input -> cache.computeIfAbsent(input, function);
    }

    public static <T, U> Function<T, U> memoize(final Function<T, U> function) {
        return new Memoizer<T, U>().doMemoize(function);
    }
}
