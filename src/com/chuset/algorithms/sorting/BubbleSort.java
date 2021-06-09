package com.chuset.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new Integer[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
    }

    public static <T extends Comparable<T>> T[] bubbleSort(final T[] array) {
        T temp;
        boolean isSorted = false;
        final int limit1 = array.length - 1;
        for (int i = 0; i < limit1 && !isSorted; i++) {
            final int limit2 = limit1 - i;
            isSorted = true;
            for (int j = 0; j < limit2; j++) {
                final int indexToCompareTo = j + 1;
                final int comparisonResult = array[j].compareTo(array[indexToCompareTo]);
                if (comparisonResult > 0) {
                    temp = array[j];
                    array[j] = array[indexToCompareTo];
                    array[indexToCompareTo] = temp;
                    isSorted = false;
                }
            }
        }
        return array;
    }
}
