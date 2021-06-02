package com.chuset.stacks.usingArray;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class MyStack<E> {

    private final List<E> dynamicArray;

    // Default size of 10
    public MyStack() {
        dynamicArray = new ArrayList<>();
    }

    public MyStack(final int size) {
        dynamicArray = new ArrayList<>(size);
    }

    public void push(final E value) {
        dynamicArray.add(value);
    }

    public E pop() {
        if (dynamicArray.isEmpty()) {
            throw new EmptyStackException();
        }
        return dynamicArray.remove(dynamicArray.size() - 1);
    }

    public E peek() {
        if (dynamicArray.isEmpty()) {
            throw new EmptyStackException();
        }
        return dynamicArray.get(dynamicArray.size() - 1);
    }

    public boolean isEmpty() {
        return dynamicArray.isEmpty();
    }

    @Override
    public String toString() {
        if (dynamicArray.isEmpty()) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        final int limit = dynamicArray.size() - 1;
        for (int i = 0; i < limit; i++) {
            sb.append(i + 1).append(": ").append(dynamicArray.get(i)).append('\n');
        }
        return sb.append(dynamicArray.size()).append(": ").append(dynamicArray.get(dynamicArray.size() - 1)).toString();
    }

    public static void main(String[] args) {
        final MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        System.out.printf("stack = %n%s%n", stack);

        stack.push(3);
        System.out.printf("stack = %n%s%n", stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.printf("stack = %n%s%n", stack);

        stack.pop();
        System.out.printf("stack = %n%s%n", stack);
    }
}
