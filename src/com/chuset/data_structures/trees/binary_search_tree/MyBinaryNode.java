package com.chuset.data_structures.trees.binary_search_tree;

public class MyBinaryNode<T extends Comparable<T>> {

    private T value;
    private MyBinaryNode<T> left;
    private MyBinaryNode<T> right;

    public MyBinaryNode(final T value, final MyBinaryNode<T> left, final MyBinaryNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public MyBinaryNode(final T value) {
        this(value, null, null);
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public MyBinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(final MyBinaryNode<T> left) {
        this.left = left;
    }

    public MyBinaryNode<T> getRight() {
        return right;
    }

    public void setRight(final MyBinaryNode<T> right) {
        this.right = right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean isLeaf() {
        return right == null && left == null;
    }
}
