package com.czellmer1324;

import com.czellmer1324.CustomLinkedList.LinkedList;
import com.czellmer1324.Queue.Queue;

/**
 * Hello world!
 *
 */
public class Main
{
    static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        testLinkedList();
        testQueue();
    }

    static void testLinkedList() {
        IO.println("Testing linked list.");
        IO.println("Testing creation of linked list and normal adding");
        LinkedList<Integer> list = new LinkedList<>();

        IO.println("Testing is empty before adding anything");
        IO.println(list.isEmpty());
        list.add(1);
        list.add(5);
        list.add(6);
        list.add(7);

        printList(list);
        IO.println("Testing isEmpty after adding values");
        IO.println(list.isEmpty());

        IO.println("Testing adding at a given index");
        list.add(10, 3);
        printList(list);

        IO.println();
        IO.println("Testing get first and last");
        IO.println(list.getFirst());
        IO.println(list.getLast());

        IO.println();
        IO.println("Testing removing");
        Integer i = list.remove(4);
        IO.println("int that was removed: " + i);
        printList(list);

        IO.println();
        IO.println("Testing getting from a certain index");
        IO.println(list.get(2));
        
        IO.println();
        IO.println("Testing set method");
        list.set(15, 3);
        printList(list);
    }

    static void printList(LinkedList<Integer> l) {
        IO.println();
        IO.println("Size: " + l.size());
        for (Integer i : l) {
            IO.println(i);
        }
    }

    static void testQueue() {
        IO.println();
        IO.println("Now testing the queue");
        Queue<String> q = new Queue<>();
        IO.println("Testing is empty before adding anything");
        IO.println(q.isEmpty());

        IO.println();
        IO.println("Testing enqueuing ");
        q.enqueue("Hello");
        q.enqueue("What is up");
        q.enqueue("How is it going");
        printQueue(q);
        IO.println("Testing isEmpty after adding stuff");
        IO.println(q.isEmpty());

        IO.println();
        IO.println("Testing peek");
        IO.println("The peek return: " + q.peek());
        printQueue(q);

        IO.println();
        IO.println("Testing dequeue");
        IO.println("The dequeue return: " + q.dequeue());
        printQueue(q);
    }

    static void printQueue(Queue<String> q) {
        IO.println();
        IO.println("Size: " + q.size());
        for (String s : q) {
            IO.println(s);
        }
    }
}
