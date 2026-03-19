package com.czellmer1324.Queue;

import com.czellmer1324.CustomLinkedList.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class Queue<T> implements Iterable<T>{
    private final LinkedList<T> list = new LinkedList<>();

    public void enqueue(T value) {
        list.add(value);
    }

    public T dequeue() {
        if (isEmpty()) throw new EmptyQueueException("Cannot perform because the queue is empty");
        return list.remove(0);
    }

    public T peek() {
        if (isEmpty()) throw new EmptyQueueException("Cannot perform because the queue is empty");
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
