package com.czellmer1324.CustomLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T>{
    ListNode<T> first;
    ListNode<T> last;
    int size = 0;

    public void add(T value) {
        if (first == null) {
            first = new ListNode<>(value);
            last = first;
        } else {
            last.setNextNode(new ListNode<>(value));
            last = last.getNextNode();
        }

        size++;
    }

    public void add(T value, int index) {
        if (index == 0) {
            first = new ListNode<>(value, first);
            if (first.nextNode == null) {
                last = first;
            }
        } else {
            ListNode<T> curNode = first.getNextNode();
            ListNode<T> previousNode = first;
            int counter = 1;
            while(counter != index) {
                counter++;
                previousNode = curNode;
                curNode = curNode.getNextNode();
            }

            ListNode<T> newNode = new ListNode<>(value);
            previousNode.setNextNode(newNode);
            newNode.setNextNode(curNode);
            if (curNode == null) {
                last = newNode;
            }
        }

        size++;
    }

    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for LinkedList with size of " + size);
        }

        if (index == 0) {
            ListNode<T> temp = first;
            first = first.getNextNode();
            size--;
            return temp.getValue();
        } else {
            //Skip the first node because it has already been checked
            ListNode<T> curNode = first.getNextNode();
            int counter = 1;
            ListNode<T> prevNode = first;

            while (counter != index) {
                counter++;
                prevNode = curNode;
                curNode = curNode.getNextNode();
            }
            //TODO: Update the last node if removing at the end
            prevNode.setNextNode(curNode.getNextNode());
            if (index == size - 1) {
                last = prevNode;
            }
            size--;
            return curNode.getValue();
        }
    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for LinkedList with size of " + size);
        }

        if (index == 0) {
            return first.getValue();
        } else if(index == size - 1) {
            return last.getValue();
        } else {
            ListNode<T> curNode = first;
            int counter = 0;
            while (counter != index) {
                counter++;
                curNode = curNode.getNextNode();
            }

            return curNode.getValue();
        }
    }

    public void set(T value, int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for LinkedList with size of " + size);
        }

        if (index == 0) {
            first.setValue(value);
        } else {
            // Skip first as it has already been checked
            ListNode<T> curNode = first.getNextNode();
            int counter = 1;

            while (counter != index) {
                counter++;
                curNode = curNode.getNextNode();
            }

            curNode.setValue(value);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListNode<T> curNode = first;

            @Override
            public boolean hasNext() {
                return (curNode != null);
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                ListNode<T> temp = curNode;
                curNode = curNode.getNextNode();
                return temp.getValue();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    private static class ListNode<T> {
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
}
