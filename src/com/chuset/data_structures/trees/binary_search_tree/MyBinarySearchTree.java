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

    public void insert(final T value) {
        if (root == null) {
            root = new MyBinaryNode<>(value);
            return;
        }
        insert(root, value);
    }

    private void insert(final MyBinaryNode<T> current, final T value) {
        // If value < current.getValue()    --> comparisonResult = 1
        // If value > current.getValue()    --> comparisonResult = -1
        // If the value is already there nothing should be done as you cannot insert duplicates into a BST
        final int comparisonResult = current.getValue().compareTo(value);
        if (0 < comparisonResult) {
            if (current.getLeft() == null) {
                current.setLeft(new MyBinaryNode<>(value));
            } else {
                insert(current.getLeft(), value);
            }
        } else if (0 > comparisonResult) {
            if (current.getRight() == null) {
                current.setRight(new MyBinaryNode<>(value));
            } else {
                insert(current.getRight(), value);
            }
        }
    }

    @Override
    public String toString() {
        return toString(root, 0);
    }

    private String toString(MyBinaryNode<T> node, int tabCount) {
        final StringBuilder sb = new StringBuilder();
        sb.append(node.getValue()).append('\n');
        tabCount++;
        if (node.getLeft() != null) {
            sb.append("\t".repeat(Math.max(0, tabCount))).append("Left: ").append(toString(node.getLeft(), tabCount));
        }
        if (node.getRight() != null) {
            sb.append("\t".repeat(Math.max(0, tabCount))).append("Right: ").append(toString(node.getRight(), tabCount));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final MyBinarySearchTree<Integer> tree = new MyBinarySearchTree<>();
        tree.insert(9);
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
