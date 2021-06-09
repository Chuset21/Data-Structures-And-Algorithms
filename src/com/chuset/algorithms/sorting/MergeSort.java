package com.chuset.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortArray(new Integer[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
    }

    // Should cast the returned array to the original type as this returns an Object[]
    public static <T extends Comparable<T>> Object[] mergeSortArray(final T[] array) {
        return mergeSort(new ArrayList<>(Arrays.asList(array))).toArray(new Object[0]);
    }

    public static <T extends Comparable<T>> List<T> mergeSortList(final List<T> list) {
        return mergeSort(list);
    }

    private static <T extends Comparable<T>> List<T> mergeSort(final List<T> list) {
        if (list.size() == 1) {
            return list;
        }
        // Split Array in into right and left
        final int splitPoint = list.size() / 2;
        return merge(
                mergeSort(list.subList(0, splitPoint)), mergeSort(list.subList(splitPoint, list.size())));
    }

    private static <T extends Comparable<T>> List<T> merge(final List<T> left, final List<T> right) {
        final List<T> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        // Keep merging until we are done with one of the sides
        while (leftIndex < left.size() && rightIndex < right.size()) {
            // <= Makes merge sort stable
            merged.add(left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0 ?
                    left.get(leftIndex++) : right.get(rightIndex++));
        }
        // Merging all "leftovers" elements as is because we know they are sorted
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        return merged;
    }
}
