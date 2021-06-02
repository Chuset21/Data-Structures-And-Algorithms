package com.chuset.coding_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FirstRecurringCharacter {

    private static Object[] array1 = {1, 5, 8, 5, 1, 8, 8, 7, 4, 4, 10};
    private static final boolean MAKE_SCALABLE = false; // For testing large scale time duration
    private static final int ARRAY_SIZE = 100000;

    public static void main(String[] args) {
        if (MAKE_SCALABLE) {
            array1 = new Object[ARRAY_SIZE];
            Random s = new Random();
            Arrays.setAll(array1, i -> s.nextLong());
        }

        long startTime = System.nanoTime();
        System.out.format("Solution result: %s with time of - %d%n",
                firstRecurringItem(array1), (System.nanoTime() - startTime));
    }

    private static <T> T firstRecurringItem(T[] array) {
        final Set<T> set = new HashSet<>();
        for (final T t : array) {
            if (set.contains(t)) {
                return t;
            } else {
                set.add(t);
            }
        }
        return null;
    }
}
