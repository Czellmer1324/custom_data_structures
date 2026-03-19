package com.czellmer1324.CustomLinkedList;

class ListNode<T> {
    private ListNode<T> nextNode;
    private T value;
    protected ListNode(T value) {
        this.value = value;
    }

    protected ListNode(T value, ListNode<T> nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    protected T getValue() {
        return value;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    protected ListNode<T> getNextNode() {
        return nextNode;
    }

    protected void setNextNode(ListNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
