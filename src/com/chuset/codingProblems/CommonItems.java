package com.chuset.codingProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CommonItems {

    private static Object[] array1 = {'a', "asd", '7', 'r', "null"};
    private static Object[] array2 = {'z', "asd", null, 'x'};
    private static final boolean MAKE_SCALABLE = true; // For testing large scale time duration
    private static final int ARRAY_SIZE = 100000;

    public static void main(String[] args) {
        if (MAKE_SCALABLE) {
            array1 = new Object[ARRAY_SIZE];
            array2 = new Object[ARRAY_SIZE];
            Random s = new Random();
            Arrays.setAll(array1, i -> s.nextLong());

            Arrays.setAll(array2, i -> s.nextLong());
        }

        long startTime = System.nanoTime();
        System.out.format("Bad solution result: %s with time of - %d%n",
                containsCommonItem(array1, array2), (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        System.out.format("Better solution result: %s with time of - %d%n",
                containsCommonItemBetter(array1, array2), (System.nanoTime() - startTime));

        startTime = System.nanoTime();
        System.out.format("Better and cleaner solution result: %s with time of - %d%n",
                containsCommonItemBetterAndCleaner(array1, array2), (System.nanoTime() - startTime));
    }

    // Naive approach
    private static <T> boolean containsCommonItem(T[] array1, T[] array2) {
        for (final T a : array1) {
            for (final T b : array2) {
                if (a.equals(b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static <T> boolean containsCommonItemBetter(T[] array1, T[] array2) {
        Set<T> setOfFirstArray = new HashSet<>(Arrays.asList(array1));
        for (final T t : array2) {
            if (setOfFirstArray.contains(t)) {
                return true;
            }
        }
        return false;
    }

    private static <T> boolean containsCommonItemBetterAndCleaner(T[] array1, T[] array2) { // Only better for big arrays
        HashSet<T> setOfFirstArray = new HashSet<>(Arrays.asList(array1));
        return Arrays.stream(array2).anyMatch(setOfFirstArray::contains);
    }
}
