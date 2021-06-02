package com.chuset.queues.usingStack;

import java.util.Stack;

public class MyQueue<E> {

    private final Stack<E> stack;
    private final Stack<E> auxiliaryStack;

    public MyQueue() {
        stack = new Stack<>();
        auxiliaryStack = new Stack<>();
    }

    public void enqueue(final E value) {
        stack.push(value);
    }

    public E dequeue() {
        fillAuxiliaryStackWithStack();
        final E value = auxiliaryStack.pop();
        fillStackWithAuxiliaryStack();
        return value;
    }

    public E peek() {
        fillAuxiliaryStackWithStack();
        final E value = auxiliaryStack.peek();
        fillStackWithAuxiliaryStack();
        return value;
    }

    @Override
    public String toString() {
        final Object[] stackAsArray = stack.toArray();
        final StringBuilder sb = new StringBuilder();

        final int limit = stackAsArray.length - 1;
        for (int index = 0; index < limit; index++) {
            sb.append(index + 1).append(": ").append(stackAsArray[index]).append('\n');
        }
        return sb.append(stackAsArray.length).append(": ").append(stackAsArray[limit]).toString();
    }

    private void fillAuxiliaryStackWithStack() {
        while (!stack.isEmpty()) { // Store the reverse order of the stack in "auxiliaryStack"
            auxiliaryStack.push(stack.pop());
        }
    }

    private void fillStackWithAuxiliaryStack() {
        while (!auxiliaryStack.isEmpty()) { // Return stack to the original state
            stack.push(auxiliaryStack.pop());
        }
    }

    public static void main(String[] args) {
        final MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("John");
        queue.enqueue("Cassidy");
        queue.enqueue("David");
        System.out.printf("queue = %n%s%n", queue);

        System.out.printf("Dequeued value: %s%n", queue.dequeue());
        System.out.printf("queue = %n%s%n", queue);

        System.out.printf("Peeked value: %s%n", queue.peek());
        System.out.printf("Dequeued value: %s%n", queue.dequeue());
        System.out.printf("queue = %n%s%n", queue);
    }
}
