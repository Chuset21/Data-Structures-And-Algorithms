package com.chuset.algorithms.recursion;

public class ReverseString {

    private static final String STRING = "STRING";

    public static void main(String[] args) {
        long i = System.nanoTime();
        System.out.printf("'%s' with a time of: %d%n", reverseStringRecursively(STRING), System.nanoTime() - i);

        i = System.nanoTime();
        System.out.printf("'%s' with a time of: %d%n", reverseBetter(STRING), System.nanoTime() - i);
    }

    public static String reverseStringRecursively(final String string) {
        if (string == null || string.length() < 2) {
            return string;
        } // StringBuilder is faster than String concatenation
        return new StringBuilder().append(reverseStringRecursively(string.substring(1))).
                append(string.charAt(0)).toString();
    }

    public static String reverseBetter(final String string) {
        if (string == null || string.length() < 2) {
            return string;
        }
        return new StringBuilder(string).reverse().toString();
    }
}
