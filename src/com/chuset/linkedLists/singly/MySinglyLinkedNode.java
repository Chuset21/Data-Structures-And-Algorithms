package com.chuset.linkedLists.singly;

public class MySinglyLinkedNode<E> {

    private E value;
    private MySinglyLinkedNode<E> next;

    public MySinglyLinkedNode(final E value, final MySinglyLinkedNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public MySinglyLinkedNode(final E value) {
        this(value, null);
    }

    public E getValue() {
        return value;
    }

    public void setValue(final E value) {
        this.value = value;
    }

    public MySinglyLinkedNode<E> getNext() {
        return next;
    }

    public void setNext(final MySinglyLinkedNode<E> next) {
        this.next = next;
    }
}
