package com.chuset.bigO;

public class LogAllPairsOfArray {

    private static final Integer[] BOXES = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        logAllPairsOfArray(BOXES);
    }

    private static <T> void logAllPairsOfArray(T[] array) { // O(n^2) --> Quadratic Time
        for (final T firstPair : array) {
            for (final T secondPair : array) {
                System.out.printf("%s, %s%n", firstPair, secondPair);
            }
        }
    }
}
