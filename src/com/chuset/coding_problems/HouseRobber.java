package com.chuset.coding_problems;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    /*
    You are a professional robber planning to rob houses along a street.
    Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
    that adjacent houses have security systems connected and it will automatically contact the police if two adjacent
    houses were broken into on the same night.

    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
    can rob tonight without alerting the police.

    Example 1:

    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

    Example 2:

    Input: nums = [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    Total amount you can rob = 2 + 9 + 1 = 12.

    Example 3:

    Input: nums = [2,1,1,2]
    Output: 4
    Explanation: Rob house 1 (money = 2), rob house 4 (money = 2).
    Total amount you can rob = 2 + 2 = 4.
     */

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    public static int rob(final int[] nums) {
        return robbed(nums, nums.length - 1, new HashMap<>());
    }

    private static int robbed(final int[] nums, final int i, final Map<Integer, Integer> map) {
        if (i < 0) {
            return 0;
        } else if (map.containsKey(i)) {
            return map.get(i);
        }

        map.put(i, Math.max(nums[i] + robbed(nums, i - 2, map), robbed(nums, i - 1, map)));
        return map.get(i);
    }
}
