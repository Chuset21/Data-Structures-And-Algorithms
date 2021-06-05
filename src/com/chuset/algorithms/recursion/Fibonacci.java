package com.chuset.algorithms.recursion;

public class Fibonacci {

    private static final long FIBONACCI_INDEX = 30;

    public static void main(String[] args) {
        System.out.printf("Fibonacci of %d: %d%n", FIBONACCI_INDEX, fibonacci(FIBONACCI_INDEX));
        System.out.printf("Fibonacci of %d: %d%n", FIBONACCI_INDEX, fibonacciBetter(FIBONACCI_INDEX));
    }
    public static long fibonacci(final long n) { // O(2^n)
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacciBetter(final long n) {
        return fibonacciBetterHelper(n, 1, 0);
    }

    private static long fibonacciBetterHelper(final long n, final long val, final long prev) { // O(n)
        if (n == 0) {
            return prev;
        } else if (n == 1) {
            return val;
        }
        return fibonacciBetterHelper(n - 1, val + prev, val);
    }

    public static long fibonacciIteratively(final long n) { // O(n)
        if (n <= 2) {
            return 1;
        }
        long result = 1;
        long lastNumber = 0;
        for (int i = 1; i < n; i++) {
            final long temp = result;
            result += lastNumber;
            lastNumber = temp;
        }
        return result;
    }
}
