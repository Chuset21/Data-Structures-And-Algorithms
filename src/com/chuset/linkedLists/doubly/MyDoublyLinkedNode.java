package com.chuset.linkedLists.doubly;

public class MyDoublyLinkedNode<E> {

    private E value;
    private MyDoublyLinkedNode<E> previous;
    private MyDoublyLinkedNode<E> next;

    public MyDoublyLinkedNode(final E value, final MyDoublyLinkedNode<E> previous, final MyDoublyLinkedNode<E> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public MyDoublyLinkedNode(final E value) {
        this(value, null, null);
    }

    public E getValue() {
        return value;
    }

    public void setValue(final E value) {
        this.value = value;
    }

    public MyDoublyLinkedNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(final MyDoublyLinkedNode<E> previous) {
        this.previous = previous;
    }

    public MyDoublyLinkedNode<E> getNext() {
        return next;
    }

    public void setNext(final MyDoublyLinkedNode<E> next) {
        this.next = next;
    }
}
