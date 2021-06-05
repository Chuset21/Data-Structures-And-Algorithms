package com.chuset.algorithms.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(25)); // Biggest number possible is 25, after that it overflows
    }

    public static long factorial(final long number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }

    public static long findFactorialIteratively(long number) {
        long result = 1;
        while (number > 0) {
            result *= number--;
        }
        return result;
    }
}
