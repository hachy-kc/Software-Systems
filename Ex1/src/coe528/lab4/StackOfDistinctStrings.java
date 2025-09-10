package coe528.lab4;

import java.util.ArrayList;

// Exercise 1: StackOfDistinctStrings
public class StackOfDistinctStrings {
    // Overview: StacksOfDistinctStrings are mutable, bounded
    // collection of distinct strings that operate in
    // LIFO (Last-In-First-Out) order.
    //
    // The abstraction function is:
    // AF(items) = a stack of distinct strings represented by 'items' where items.get(size-1) is the top element.
    //
    // The rep invariant is:
    // RI(items) = items contains no duplicate strings.

    // the rep
    private ArrayList<String> items;

    // constructor
    public StackOfDistinctStrings() {
        // EFFECTS: Creates a new StackOfDistinctStrings object
        items = new ArrayList<String>();
    }

    public void push(String element) throws Exception {
        // MODIFIES: this
        // EFFECTS: Appends the element at the top of the stack
        // if the element is not in the stack, otherwise
        // does nothing.
        if (element == null) throw new Exception();
        if (!items.contains(element))
            items.add(element);
    }

    public String pop() throws Exception {
        // MODIFIES: this
        // EFFECTS: Removes an element from the top of the stack
        if (items.size() == 0) throw new Exception();
        return items.remove(items.size() - 1);
    }

    public boolean repOK() {
        // EFFECTS: Returns true if the rep invariant holds for this
        // object; otherwise returns false
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).equals(items.get(j)))
                    return false;
            }
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        // EFFECTS: Returns a string that contains the strings in the
        // stack and the top element. Implements the
        // abstraction function.
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append(item).append(" ");
        }
        return sb.toString();
    }
}

