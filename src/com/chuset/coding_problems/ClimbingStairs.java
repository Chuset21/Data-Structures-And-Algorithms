package com.chuset.coding_problems;

public class ClimbingStairs {

    /*
    You are climbing a staircase. It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



    Example 1:

    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:

    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

    Example 3:

    Input: n = 4
    Output: 5
    Explanation: There are five ways to climb to the top.
    1. 1 step + 1 step + 1 step + 1 step
    2. 1 step + 2 step + 1 step
    3. 1 step + 1 step + 2 step
    4. 2 step + 1 step + 1 step
    5. 2 step + 2 step
     */

    /*
    Output: 4
    1. 1 + 1 + 1 + 1
    2. 1 + 2 + 1
    3. 1 + 1 + 2
    4. 2 + 1 + 1
    5. 2 + 2
     */

    final static int[] MEMO = new int[46];

    public static int climbStairs(final int n) {
        if (n == 2) {
            return 2;
        } else if (n == 1) {
            return 1;
        }
        if (MEMO[n] == 0) {
            MEMO[n] = climbStairs(n - 2) + climbStairs(n - 1);
        }
        return MEMO[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
