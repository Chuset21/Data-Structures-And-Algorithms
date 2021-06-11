package com.chuset.coding_problems;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.



    Example 1:

    Input: s = "()"
    Output: true

    Example 2:

    Input: s = "()[]{}"
    Output: true

    Example 3:

    Input: s = "(]"
    Output: false

    Example 4:

    Input: s = "([)]"
    Output: false

    Example 5:

    Input: s = "{[]}"
    Output: true
     */

    public static boolean isValid(final String string) {
        final HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            final Character ch = string.charAt(i);

            if (!pairs.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || !stack.pop().equals(pairs.get(ch))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}{}"));
    }
}
