package com.chuset.data_structures.linked_lists.singly;

public class MySinglyLinkedList<E> {

    private MySinglyLinkedNode<E> head;
    private MySinglyLinkedNode<E> tail;
    private int length;

    public MySinglyLinkedList(final E value) {
        head = new MySinglyLinkedNode<>(value);
        tail = head;
        length = 1;
    }

    public void prepend(final E value) {
        head = new MySinglyLinkedNode<>(value, head);
        length++;
    }

    public void append(final E value) {
        final MySinglyLinkedNode<E> newTail = new MySinglyLinkedNode<>(value);
        tail.setNext(newTail);
        tail = newTail;
        length++;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        MySinglyLinkedNode<E> currentNode = head;
        final StringBuilder sb = new StringBuilder();
        sb.append(currentNode.getValue());
        currentNode = currentNode.getNext();

        while (currentNode != null) {
            sb.append("-->").append(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println(sb);
        System.out.println();
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

        final MySinglyLinkedNode<E> leader = traverseToIndex(index - 1);

        leader.setNext(new MySinglyLinkedNode<>(value, leader.getNext()));
        length++;
    }

    public void remove(final int index) {
        if (index == 0) {
            head = head.getNext();
            return;
        }

        final MySinglyLinkedNode<E> leader = traverseToIndex(index - 1);
        leader.setNext(leader.getNext().getNext());
        length--;
    }

    public void reverse() {
        MySinglyLinkedNode<E> first = head;
        tail = head;
        MySinglyLinkedNode<E> second = first.getNext();

        final int limit = length - 1;
        for (int i = 0; i < limit; i++) {
            final MySinglyLinkedNode<E> temp = second.getNext();
            second.setNext(first);
            first = second;
            second = temp;
        }
        head.setNext(null);
        head = first;
    }

    private MySinglyLinkedNode<E> traverseToIndex(final int index) {
        if (index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        MySinglyLinkedNode<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public E get(final int index) {
        return traverseToIndex(index).getValue();
    }

    public MySinglyLinkedNode<E> getHead() {
        return head;
    }

    public MySinglyLinkedNode<E> getTail() {
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
        final MySinglyLinkedList<String> mySinglyLinkedList = new MySinglyLinkedList<>("Joe");
        mySinglyLinkedList.append("8");
        System.out.println(mySinglyLinkedList);

        mySinglyLinkedList.append("Good morning");
        mySinglyLinkedList.printList();

        mySinglyLinkedList.prepend("four");
        mySinglyLinkedList.printList();

        mySinglyLinkedList.insert(2, "15");
        mySinglyLinkedList.printList();

        mySinglyLinkedList.remove(2);
        mySinglyLinkedList.printList();

        mySinglyLinkedList.reverse();
        mySinglyLinkedList.printList();
    }
}
