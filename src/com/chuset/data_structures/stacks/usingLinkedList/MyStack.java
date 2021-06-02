package com.chuset.data_structures.stacks.usingLinkedList;

import com.chuset.data_structures.linked_lists.singly.MySinglyLinkedNode;

import java.util.EmptyStackException;

public class MyStack<E> {

    private MySinglyLinkedNode<E> top;
//    private MySinglyLinkedNode<E> bottom;
    private int length;

    public MyStack() {
        top = null;
//        bottom = null;
        length = 0;
    }

    public void push(final E value) {
        top = new MySinglyLinkedNode<>(value, top);
//        if (length == 0) {
//            bottom = top;
//        }
        length++;
    }

    public E pop() {
        if (length == 0) {
            throw new EmptyStackException();
        }

        final MySinglyLinkedNode<E> poppedValue = top;
        top = top.getNext();
        length--;

//        if (length == 0) {
//            bottom = null;
//        }

        return poppedValue.getValue();
    }

    public E peek() {
        if (length == 0) {
            throw new EmptyStackException();
        }

        return top.getValue();
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        MySinglyLinkedNode<E> currentNode = top;
        final StringBuilder sb = new StringBuilder();

        for (int i = 1; currentNode != null ; i++) {
            sb.append(i).append(": ").append(currentNode.getValue());
            final MySinglyLinkedNode<E> temp = currentNode.getNext();

            if (temp != null) {
                sb.append('\n');
            }
            currentNode = temp;
        }
        return sb.toString();
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
