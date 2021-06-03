package com.chuset.data_structures.trees.binary_search_tree;

public class MyBinarySearchTree<T extends Comparable<T>> {

    private MyBinaryNode<T> root;

    public MyBinarySearchTree(final T rootValue) {
        this.root = new MyBinaryNode<>(rootValue);
    }

    public MyBinarySearchTree() {
        root = null;
    }

    public boolean contains(final T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(final MyBinaryNode<T> current, final T value) {
        if (current == null) {
            return false;
        }

        final int comparisonResult = root.getValue().compareTo(value);
        if (comparisonResult == 0) {
            return true;
        } else if (comparisonResult < 0) {
            return containsRecursive(current.getLeft(), value);
        } else {
            return containsRecursive(current.getRight(), value);
        }
    }
}
