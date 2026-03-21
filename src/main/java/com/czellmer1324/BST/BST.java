package com.czellmer1324.BST;

public class BST<T extends Comparable<T>> {
    private TreeNode<T> root;

    public void insert(T value) {
        root = recursiveInsert(root, value);
    }

    private void balance() {

    }

    private TreeNode<T> recursiveInsert(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.leftNode = recursiveInsert(node.leftNode, value);
        } else if (value.compareTo(node.value) > 0) {
            node.rightNode = recursiveInsert(node.rightNode, value);
        }

        // this will ignore duplicate values
        return node;
    }

    public boolean search(T value) {
        return search(root, value);
    }

    private boolean search(TreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (value.compareTo(node.value) > 0) {
            return search(node.rightNode, value);
        } else if (value.compareTo(node.value) < 0) {
            return search(node.leftNode, value);
        } else {
            return true;
        }
    }


    public void printTreeInOrder() {
        inOrderTraversal(root);
    }

    // I want to solve a large problem (printing the entire tree in order)
    /*
    The small problem is that I need to print each node value and I only have a pointer to the root
    So the steps is I need to go until I hit a leaf
     */
    private void inOrderTraversal(TreeNode<T> node) {
        // Catch case, when the recursion stops
        // Stop the recursion when you hit a null node, means you cannot go farther in this direction
        if (node == null) {
            return;
        }

        // Since we are printing in order I need to go all the way to the left most leaf first
        inOrderTraversal(node.leftNode);
        // Print the current node value first since it will be smaller than the node's to the right
        IO.println(node.value);
        // Once current node's value has printed move the right node
        inOrderTraversal(node.rightNode);
    }

    private static class TreeNode<T extends Comparable<T>> {
        private final T value;
        private TreeNode<T> leftNode;
        private TreeNode<T> rightNode;

        private TreeNode(T value) {
            this.value = value;
        }
    }
}
