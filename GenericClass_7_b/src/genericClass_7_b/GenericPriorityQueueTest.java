package genericClass_7_b;

public class GenericPriorityQueueTest {
	public static void main(String[] args) {
        // Test PriorityQueue with Integer
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        intQueue.enqueue(10);
        intQueue.enqueue(5);
        intQueue.enqueue(30);
        intQueue.enqueue(1);
        System.out.println("PriorityQueue (Integer) - Peek: " + intQueue.peek());
        System.out.println("PriorityQueue (Integer) - Dequeue: " + intQueue.dequeue());
        System.out.println("PriorityQueue (Integer) - Dequeue: " + intQueue.dequeue());

        // Test PriorityQueue with Double
        PriorityQueue<Double> doubleQueue = new PriorityQueue<>();
        doubleQueue.enqueue(3.5);
        doubleQueue.enqueue(1.2);
        doubleQueue.enqueue(7.8);
        doubleQueue.enqueue(2.4);
        System.out.println("PriorityQueue (Double) - Peek: " + doubleQueue.peek());
        System.out.println("PriorityQueue (Double) - Dequeue: " + doubleQueue.dequeue());
        System.out.println("PriorityQueue (Double) - Dequeue: " + doubleQueue.dequeue());

        // Test PriorityQueue with String
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.enqueue("banana");
        stringQueue.enqueue("apple");
        stringQueue.enqueue("cherry");
        stringQueue.enqueue("date");
        System.out.println("PriorityQueue (String) - Peek: " + stringQueue.peek());
        System.out.println("PriorityQueue (String) - Dequeue: " + stringQueue.dequeue());
        System.out.println("PriorityQueue (String) - Dequeue: " + stringQueue.dequeue());
    }
}
