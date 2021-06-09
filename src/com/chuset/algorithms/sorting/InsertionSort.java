package com.chuset.algorithms.sorting;

import java.util.*;

public class InsertionSort {

    private static Long[] array1 = {99L, 44L, 6L, 2L, 1L, 5L, 63L, 87L, 283L, 4L, 0L};
    private static final boolean MAKE_SCALABLE = false; // For testing large scale time duration
    private static final int ARRAY_SIZE = 2000;

    public static void main(String[] args) {
        if (MAKE_SCALABLE) {
            array1 = new Long[ARRAY_SIZE];
            Random s = new Random();
            Arrays.setAll(array1, i -> s.nextLong());
        }

        final long startTime = System.nanoTime();
        System.out.format("Time of: %d%nSolution result: %s%n",System.nanoTime() - startTime,
                Arrays.toString(insertionSort(array1)));
    }

    // Should cast the returned array to the original type as this returns an Object[]
    private static <T extends Comparable<T>> Object[] insertionSort(final T[] array) {
        final List<T> list = new ArrayList<>(Arrays.asList(array));
        for (int i = 1; i < list.size(); i++) {
            T current = list.get(i);
            final int comparisonResult = current.compareTo(list.get(0));
            if (comparisonResult <= 0) {
                // Checking if current value is suppose to be first
                list.add(0, current); // Moving the value to first position
                list.remove(i + 1);
            } else {
                // Only sort value smaller than value on the left of it.
                // This is the part of insertion sort that makes it fast if the array is almost sorted.
                final int comparisonResult2 = current.compareTo(list.get(i - 1));
                if (comparisonResult2 < 0) {
                    // Find where value should go
                    for (int j = 1; j < i; j++) {
                        final int comparisonResult3 = current.compareTo(list.get(j - 1));
                        final int comparisonResult4 = current.compareTo(list.get(j));
                        if (comparisonResult3 >= 0 && comparisonResult4 < 0) {
                            // Move value to the correct spot
                            list.add(j, current);
                            list.remove(i + 1);
                            current = list.get(i);
                        }
                    }
                }
            }
        }
        return list.toArray(new Object[0]);
    }
}
