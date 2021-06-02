package com.chuset.data_structures.arrays;

public class ReverseString {

    private static final String STRING = "Hi, my name is Joseph Mother";

    public static void main(String[] args) {
        System.out.println(reverse(STRING));
        System.out.println(reverseBetter(STRING));
    }

    public static String reverse(final String original) {
        if (original == null || original.length() < 2) {
            return original;
        }

        final StringBuilder reversedString = new StringBuilder();
        for (int i = original.length() - 1; i >= 0; i--) {
            reversedString.append(original.charAt(i));
        }
        return reversedString.toString();
    }

    public static String reverseBetter(final String string) {
        if (string == null || string.length() < 2) {
            return string;
        }

        return new StringBuilder(string).reverse().toString();
    }
}
