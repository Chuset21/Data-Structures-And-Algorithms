package com.chuset.linkedLists.doubly;

public class MyDoublyLinkedList<E> {

    private MyDoublyLinkedNode<E> head;
    private MyDoublyLinkedNode<E> tail;
    private int length;

    public MyDoublyLinkedList(final E value) {
        head = new MyDoublyLinkedNode<>(value);
        tail = head;
        length = 1;
    }

    public void prepend(final E value) {
        final MyDoublyLinkedNode<E> newHead = new MyDoublyLinkedNode<>(value, null, head);
        head.setPrevious(newHead);
        head = newHead;
        length++;
    }

    public void append(final E value) {
        final MyDoublyLinkedNode<E> newTail = new MyDoublyLinkedNode<>(value, tail, null);
        tail.setNext(newTail);
        tail = newTail;
        length++;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        MyDoublyLinkedNode<E> currentNode = head;
        final StringBuilder sb = new StringBuilder();
        sb.append(currentNode.getValue());
        currentNode = currentNode.getNext();

        while (currentNode != null) {
            sb.append("-->").append(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println(sb);
    }

    public void insert(final int index, final E value) {
        if (index == 0) {
            prepend(value);
            return;
        }

        if (index == length - 1) {
            append(value);
            return;
        }

        final MyDoublyLinkedNode<E> newPrevious = traverseToIndex(index - 1);
        final MyDoublyLinkedNode<E> newNext = newPrevious.getNext();

        final MyDoublyLinkedNode<E> newNode = new MyDoublyLinkedNode<>(value, newPrevious, newNext);
        newPrevious.setNext(newNode);
        newNext.setPrevious(newNode);
        length++;
    }

    public void remove(final int index) {
        if (index == 0) {
            head = head.getNext();
            head.setPrevious(null);
            return;
        }

        final MyDoublyLinkedNode<E> leader = traverseToIndex(index - 1);
        final MyDoublyLinkedNode<E> nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrevious(leader);
        length--;
    }

    private MyDoublyLinkedNode<E> traverseToIndex(final int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index > length / 2) {
            return traverseFromTail(index);
        } else {
            return traverseFromHead(index);
        }
    }

    private MyDoublyLinkedNode<E> traverseFromHead(final int index) {
        MyDoublyLinkedNode<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private MyDoublyLinkedNode<E> traverseFromTail(final int index) {
        MyDoublyLinkedNode<E> currentNode = tail;
        for (int i = index - 1; i >= 0; i--) {
            currentNode = currentNode.getPrevious();
        }
        return currentNode;
    }

    public E get(final int index) {
        return traverseToIndex(index).getValue();
    }

    public MyDoublyLinkedNode<E> getHead() {
        return head;
    }

    public MyDoublyLinkedNode<E> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return String.format("head: %s, tail: %s, length: %d", head.getValue(), tail.getValue(), length);
    }

    public static void main(String[] args) {
        final MyDoublyLinkedList<String> myDoublyLinkedList = new MyDoublyLinkedList<>("Joe");
        myDoublyLinkedList.append("8");
        System.out.println(myDoublyLinkedList);

        myDoublyLinkedList.append("Good morning");
        myDoublyLinkedList.printList();

        myDoublyLinkedList.prepend("four");
        myDoublyLinkedList.printList();

        myDoublyLinkedList.insert(2, "15");
        myDoublyLinkedList.printList();

        myDoublyLinkedList.remove(2);
        myDoublyLinkedList.printList();
    }
}
