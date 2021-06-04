package com.chuset.coding_problems;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        final int[] nums = {0, 1, 0, 3, 12, 13, 2, 0, 23, 0, 3, 0, 0, 3};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(final int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            final int temp = nums[i];
            if (temp != 0) {
                nums[i] = 0;
                nums[lastNonZeroFoundAt++] = temp;
            }
        }
    }
}
