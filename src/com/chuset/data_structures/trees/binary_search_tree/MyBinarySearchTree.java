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
        return contains(root, value);
    }

    private boolean contains(final MyBinaryNode<T> current, final T value) {
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
            return contains(current.getLeft(), value);
        } else {
            return contains(current.getRight(), value);
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
            if (current.hasLeft()) {
                insert(current.getLeft(), value);
            } else {
                current.setLeft(new MyBinaryNode<>(value));
                return true;
            }
        } else if (0 > comparisonResult) {
            if (current.hasRight()) {
                insert(current.getRight(), value);
            } else {
                current.setRight(new MyBinaryNode<>(value));
                return true;
            }
        }
        return false;
    }

    public boolean remove(final T value) {
        if (root == null) {
            return false;
        }
        return remove(root, null, value);
    }

    private boolean remove(final MyBinaryNode<T> current, final MyBinaryNode<T> parent, final T value) {
        if (current == null) {
            return false;
        }

        // If value < current.getValue()    --> comparisonResult = 1
        // If value > current.getValue()    --> comparisonResult = -1
        // If the value is already there we know that we have reached the correct parent and 'current'
        final int comparisonResult = current.getValue().compareTo(value);
        if (0 < comparisonResult) {
            return remove(current.getLeft(), current, value);
        } else if (0 > comparisonResult) {
            return remove(current.getRight(), current, value);
        }
        // Now we know that we have the correct parent and 'current'

        if (current.isLeaf()) {
            replaceChildWithNewNode(parent, value, null);
        } else if (current.hasRight() && !current.hasLeft()) {
            replaceChildWithNewNode(parent, value, current.getRight());
        } else if (current.hasLeft() && !current.hasRight()) {
            replaceChildWithNewNode(parent, value, current.getLeft());
        } else {
            MyBinaryNode<T> successor;
            if (current.getRight().hasLeft()) {
                successor = findMinAndChangeRef(current.getRight(), current.getRight().getLeft());
            } else {
                successor = findMin(current.getRight());
            }
            if (parent == null) {
                root = successor;
            } else {
                replaceChildWithNewNode(parent, value, successor);
            }
            successor.setLeft(current.getLeft());
            if (!successor.equals(current.getRight())) {
                successor.setRight(current.getRight());
            }
        }
        return true;
    }

    private MyBinaryNode<T> findMinAndChangeRef(final MyBinaryNode<T> parent, final MyBinaryNode<T> current) {
        if (current.hasLeft()) {
            return findMinAndChangeRef(parent.getLeft(), current.getLeft());
        }
        if (current.hasRight()) {
            parent.setLeft(current.getRight());
        } else {
            parent.setLeft(null);
        }
        return current;
    }

    private MyBinaryNode<T> findMin(final MyBinaryNode<T> current) {
        if (current.hasLeft()) {
            return findMin(current.getLeft());
        }
        return current;
    }

    private void replaceChildWithNewNode(final MyBinaryNode<T> parent, final T value, final MyBinaryNode<T> newNode) {
        if (parent.hasLeft() && parent.getLeft().getValue().equals(value)) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
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
            sb.append("\t".repeat(tabCount)).append("Left:  ").append(toString(current.getLeft(), tabCount));
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
        System.out.printf("The tree %s 20.%n", tree.contains(20) ? "contains" : "doesn't contain");
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(97);
        tree.insert(17);
        System.out.println(tree);

        System.out.printf("Removing 20: %s%n", tree.remove(20));
        System.out.println(tree);

        System.out.printf("Removing 4: %s%n", tree.remove(4));
        System.out.println(tree);

        tree.insert(20);
        tree.insert(18);
        tree.insert(10);
        tree.insert(11);

        System.out.println(tree);

        System.out.printf("Removing 9: %s%n", tree.remove(9));
        System.out.println(tree);
    }
}
