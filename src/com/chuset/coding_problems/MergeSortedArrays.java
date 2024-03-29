package com.chuset.coding_problems;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(new
                Integer[]{1,1,8,9,10}, new Integer[]{1,2,8,9,11,15,16})));
    }

    // Should cast the returned array to the original type as this returns an Object[]
    private static <T extends Comparable<T>> Object[] mergeSortedArrays(final T[] array1, final T[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }

        if (array2 == null || array2.length == 0) {
            return array1;
        }

        final Object[] mergedArray = new Object[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (index1 == array1.length) {
                System.arraycopy(array2, index2, mergedArray, i, mergedArray.length - i);
                break;
            }
            if (index2 == array2.length) {
                System.arraycopy(array1, index1, mergedArray, i, mergedArray.length - i);
                break;
            }

            final int comparisonResult = array1[index1].compareTo(array2[index2]);
            if (comparisonResult < 0) {
                mergedArray[i] = array1[index1++];
            } else {
                mergedArray[i] = array2[index2++];
            }
        }
        return mergedArray;
    }
}
