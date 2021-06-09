package com.chuset.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new Integer[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
    }

    private static <T extends Comparable<T>> T[] selectionSort(final T[] array) {
        T temp;
        for (int i = 0; i < array.length; i++) {
            T minValue = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                final int comparisonResult = minValue.compareTo(array[j]);
                if (comparisonResult > 0) {
                    minValue = array[j];
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = minValue;
            array[minIndex] = temp;
        }
        return array;
    }
}
