package com.chuset.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new Integer[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
    }

    public static <T extends Comparable<T>> T[] quickSort(final T[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> T[] quickSort(final T[] array, final int left, final int right) {
        int pivot;
        int partitionIndex;

        if (left < right) {
            pivot = right;
            partitionIndex = partition(array, pivot, left, right);

            // Sort left and right
            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
        return array;
    }

    public static <T extends Comparable<T>> int partition(
            final T[] array, final int pivot, final int left, final int right) {
        T pivotValue = array[pivot];
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            final int comparisonResult = array[i].compareTo(pivotValue);
            if (comparisonResult < 0) {
                swap(array, i, partitionIndex++);
            }
        }
        swap(array, right, partitionIndex);
        return partitionIndex;
    }

    private static <T extends Comparable<T>> void swap(final T[] array, final int index1, final int index2) {
        final T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
