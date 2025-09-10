package coe528.lab4;

public class Main {
    public static void main(String[] args) {
        // Test the stack implementation
        testStack();

        // Test the queue implementation
        testQueue();
    }

    private static void testStack() {
        StackOfDistinctStrings stack = new StackOfDistinctStrings();
        try {
            stack.push("ab");
            stack.push("cd");
            stack.push("ae");
            stack.push("bd");
            stack.push("test");
            stack.push("test2");
            System.out.println("Stack: " + stack);
            System.out.println("Top element: " + stack.pop());
            System.out.println("Stack after popping: " + stack);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        //queue.enqueue(4545);
        
        
        try {
            int dequeuedElement1 = queue.dequeue(); // 10
            int dequeuedElement2 = queue.dequeue(); // 20
           // int dequeuedElement3 = queue.dequeue();
            // Dequeue all elements from the queue
         //while (!queue.isEmpty()) {
         //  queue.dequeue();
           
         //}
            boolean isEmpty = queue.isEmpty(); // false

            System.out.println("Dequeued element 1: " + dequeuedElement1);
            System.out.println("Dequeued element 2: " + dequeuedElement2);
            System.out.println("Is the queue empty? " + isEmpty);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
