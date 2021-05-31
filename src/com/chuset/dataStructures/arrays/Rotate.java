package com.chuset.dataStructures.arrays;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] arr2 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        rotateRight(arr, 3);
        rotateBetter(arr2, 3, true);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    private static void rotateRight(final int[] items, int k) {
        if (items == null || items.length < 2) {
            return;
        }

        k %= items.length;
        if (k == 0) {
            return;
        }

        if (items.length % 2 == 0) { // The even method works for even and odd
            final int[] newArray = Arrays.copyOf(items, items.length);
            for (int i = 0; i < items.length; i++) {
                items[(i + k) % items.length] = newArray[i];
            }
        } else { // Not necessary, just for fun
            int j = 0;
            int nextItem = items[0];
            for (int i = 0; i < items.length; i++) {
                final int currentItem = nextItem;
                j = (j + k) % items.length;
                nextItem = items[j];
                items[j] = currentItem;
            }
        }
    }

    private static <T> void rotateBetter(final T[] items, int k, final boolean rotateRight) {
        if (items == null || items.length < 2) {
            return;
        }

        k %= items.length;
        if (k == 0) {
            return;
        }
        if (!rotateRight) {
            k = items.length - k;
        }

        reverse(items, 0, items.length - 1);
        reverse(items, 0, k - 1);
        reverse(items, k, items.length - 1);
    }

    private static <T> void reverse(final T[] nums, int low, int high) {
        while (low < high) {
            final T temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}
