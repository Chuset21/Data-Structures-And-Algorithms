package com.chuset.data_structures.trees.binary_search_tree;

public class MyBinarySearchTree<T extends Comparable<T>> {

    private MyBinaryNode<T> root;

    public MyBinarySearchTree(final T rootValue) {
        root = new MyBinaryNode<>(rootValue);
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

        // If value < current.getValue()    --> comparisonResult = 1
        // If value > current.getValue()    --> comparisonResult = -1
        // If value == current.getValue()   --> comparisonResult = 0
        final int comparisonResult = current.getValue().compareTo(value);
        if (comparisonResult == 0) {
            return true;
        } else if (0 < comparisonResult) {
            return containsRecursive(current.getLeft(), value);
        } else {
            return containsRecursive(current.getRight(), value);
        }
    }

    public boolean insert(final T value) {
        if (root == null) {
            root = new MyBinaryNode<>(value);
            return true;
        } else {
            return insert(root, value);
        }
    }

    private boolean insert(final MyBinaryNode<T> current, final T value) {
        // If value < current.getValue()    --> comparisonResult = 1
        // If value > current.getValue()    --> comparisonResult = -1
        // If the value is already there nothing should be done as you cannot insert duplicates into a BST
        final int comparisonResult = current.getValue().compareTo(value);
        if (0 < comparisonResult) {
            if (current.getLeft() == null) {
                current.setLeft(new MyBinaryNode<>(value));
                return true;
            } else {
                insert(current.getLeft(), value);
            }
        } else if (0 > comparisonResult) {
            if (current.getRight() == null) {
                current.setRight(new MyBinaryNode<>(value));
                return true;
            } else {
                insert(current.getRight(), value);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return toString(root, 0);
    }

    private String toString(final MyBinaryNode<T> current, int tabCount) {
        if (root == null) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        sb.append(current.getValue()).append('\n');
        tabCount++;
        if (current.getLeft() != null) {
            sb.append("\t".repeat(tabCount)).append("Left: ").append(toString(current.getLeft(), tabCount));
        }
        if (current.getRight() != null) {
            sb.append("\t".repeat(tabCount)).append("Right: ").append(toString(current.getRight(), tabCount));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
        System.out.println(tree.insert(9));
        tree.insert(4);
        tree.insert(20);
        System.out.println(tree.contains(20));
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(170);
        System.out.println(tree);
    }
}
