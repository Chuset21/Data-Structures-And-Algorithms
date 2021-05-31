package com.chuset.bigO;

import java.util.Arrays;

public class ForLoop {

    private static final String[] NEMO = {"nemo"};
    private static final String[] EVERYONE = {"dory", "bruce", "marlin", "nemo", "gill", "bloat", "nigel", "squirt",
            "darla", "hank"};

    public static void main(String[] args) {
        final String[] large = new String[100000];
        Arrays.fill(large, "nemo");

        findNemo(large);
    }

    private static void findNemo(final String[] strings) { // O(n) --> Linear Time
        for (final String string : strings) {
            if ("nemo".equals(string)) {
                System.out.println("Found NEMO!");
                return;
            }
        }
    }

    private static void findNemo2(final String[] strings){
        if (Arrays.asList(strings).contains("nemo")) {
            System.out.println("Found NEMO!");
        }
    }

    private static <T> void logFirstTwoBoxes(T[] boxes) { // O(1) --> Constant Time
        System.out.println(boxes[0]);
        System.out.println(boxes[1]);
    }
}
