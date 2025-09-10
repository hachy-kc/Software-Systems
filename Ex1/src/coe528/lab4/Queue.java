package coe528.lab4;

import java.util.LinkedList;

public class Queue<T> {
    // Internal representation of the queue
    private LinkedList<T> elements;

    // Constructor
    public Queue() {
        elements = new LinkedList<>();
    }

    // Method to enqueue an element to the rear end of the queue
    public void enqueue(T element) {
        elements.addLast(element);
    }

    // Method to dequeue an element from the front end of the queue
    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return elements.removeFirst();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Method to check if the rep invariant holds true for the current state of the queue
    public boolean repOK() {
        return elements != null;
    }

    // Method to provide a string representation of the queue's elements
    @Override
    public String toString() {
        return elements.toString();
    }
}
