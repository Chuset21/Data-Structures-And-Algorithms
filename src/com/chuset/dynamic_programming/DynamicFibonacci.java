package com.chuset.dynamic_programming;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DynamicFibonacci {

    private static final long FIBONACCI_INDEX = 30;

    private static final Map<Long, Long> CACHE = new HashMap<>();

    private static final Function<Long, Long> MEMOIZED_FIBONACCI = Memoizer.memoize(DynamicFibonacci::fibonacci);

    public static long fibonacci(final Long n) {
        return fibonacciHelper(n, 1, 0);
    }

    private static long fibonacciHelper(final long n, final long val, final long prev) { // O(n)
        if (CACHE.containsKey(n)) {
            return CACHE.get(n);
        } else if (n == 0) {
            return prev;
        } else if (n == 1) {
            return val;
        }
        CACHE.put(n, fibonacciHelper(n - 1, val + prev, val));
        return CACHE.get(n);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.printf("Fibonacci of %d: %d in %d%n",
                FIBONACCI_INDEX, MEMOIZED_FIBONACCI.apply(FIBONACCI_INDEX), System.nanoTime() - startTime);

        startTime = System.nanoTime();
        System.out.printf("Fibonacci of %d: %d in %d%n",
                FIBONACCI_INDEX, MEMOIZED_FIBONACCI.apply(FIBONACCI_INDEX), System.nanoTime() - startTime);

        final long newIndex = FIBONACCI_INDEX + 5;
        startTime = System.nanoTime();
        System.out.printf("Fibonacci of %d: %d in %d%n",
                newIndex, MEMOIZED_FIBONACCI.apply(newIndex), System.nanoTime() - startTime);
    }
}
