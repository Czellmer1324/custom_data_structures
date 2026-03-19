package com.czellmer1324.Stack;

import com.czellmer1324.CustomLinkedList.LinkedList;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T>{
    private final LinkedList<T> list = new LinkedList<>();

    public void push(T value) {
        if (isEmpty()) {
            list.add(value);
        } else {
            list.add(value, 0);
        }
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return list.getFirst();
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return list.remove(0);
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
