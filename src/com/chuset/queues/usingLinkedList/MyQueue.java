package com.chuset.queues.usingLinkedList;

import com.chuset.linkedLists.singly.MySinglyLinkedNode;

public class MyQueue<E> {

    private MySinglyLinkedNode<E> first;
    private MySinglyLinkedNode<E> last;
    private int length;

    public MyQueue() {
        first = null;
        last = null;
        length = 0;
    }

    public void enqueue(final E value) {
        final MySinglyLinkedNode<E> newNode = new MySinglyLinkedNode<>(value);
        if (length == 0) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        length++;
    }

    public E dequeue() {
        if (first == null) {
            throw new EmptyQueueException();
        }

        final MySinglyLinkedNode<E> result = first;
        first = first.getNext();
        length--;

        if (length == 0) {
            last = null;
        }

        return result.getValue();
    }

    public E peek() {
        if (first == null) {
            throw new EmptyQueueException();
        }
        return first.getValue();
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public String toString() {
        MySinglyLinkedNode<E> currentNode = first;
        final StringBuilder sb = new StringBuilder();

        for (int i = 1; currentNode != null; i++) {
            sb.append(i).append(": ").append(currentNode.getValue());
            final MySinglyLinkedNode<E> temp = currentNode.getNext();

            if (temp != null) {
                sb.append('\n');
            }
            currentNode = temp;
        }
        return sb.toString();
    }

    private static class EmptyQueueException extends RuntimeException {
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
