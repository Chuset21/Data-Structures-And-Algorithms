package com.chuset.coding_problems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TrappingRainWater {

    // The question: https://leetcode.com/problems/trapping-rain-water/

    // This is slower than the last solution but it's what I came up with
    public static int trapCleaner(final int[] heights) {
        int max = 0;
        for (final int height : heights) {
            if (max < height) {
                max = height;
            }
        }

        int waterCount = 0;
        for (int i = 1; i <= max; i++) {
            waterCount += countWaterAtLevelCleaner(heights, i);
        }
        return waterCount;
    }

    private static int countWaterAtLevelCleaner(final int[] heights, final int level) {
        int firstEnclosing = 0;
        for (int i = 0; i < heights.length; i++) {
            if (level <= heights[i]) {
                firstEnclosing = i;
                break;
            }
        }

        int lastEnclosing = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (level <= heights[i]) {
                lastEnclosing = i;
                break;
            }
        }

        int waterCount = 0;
        for (int i = firstEnclosing; i <= lastEnclosing; i++) {
            if (level > heights[i]) {
                waterCount++;
            }
        }
        return waterCount;
    }

    // This mirrors the above solution but with streams, which I find more readable
    public static int trapCleanerWithStreams(final int[] heights) {
        final int max = Arrays.stream(heights).filter(height -> height >= 0).max().orElse(0);

        return IntStream.rangeClosed(1, max).map(i -> countWaterAtLevelCleanerWithStreams(heights, i)).sum();
    }

    private static int countWaterAtLevelCleanerWithStreams(final int[] heights, final int level) {
        final int firstEnclosing = IntStream.range(0, heights.length).filter(i -> level <= heights[i]).
                findFirst().orElse(0);

        final int lastEnclosing = IntStream.iterate(heights.length - 1, i -> i >= 0, i -> i - 1).
                filter(i -> level <= heights[i]).findFirst().orElse(0);

        return (int) IntStream.rangeClosed(firstEnclosing, lastEnclosing).filter(i -> level > heights[i]).count();
    }



    public static int trapBetter(final int[] heights) {
        int totalWater = 0;

        int left = 0, leftMax = left;

        int right = heights.length - 1, rightMax = right;

        while (left < right) {
            if (heights[left] < heights[right]) {
                // increment the left pointer
                if (heights[left] >= heights[leftMax]) {
                    leftMax = left;
                } else {
                    totalWater += heights[leftMax] - heights[left];
                }
                left++;
            } else {
                // decrement the right pointer
                if (heights[right] >= heights[rightMax]) {
                    rightMax = right;
                } else {
                    totalWater += (heights[rightMax] - heights[right]);
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        final int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        long startTime = System.nanoTime();
        System.out.printf("Cleaner solution with result of %d in %d%n",
                trapCleaner(array), System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.printf("Better solution with result of %d in %d%n",
                trapBetter(array), System.nanoTime() - startTime);
    }
}
