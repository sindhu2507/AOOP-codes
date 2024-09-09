package genericClass_7_b;
import java.util.ArrayList;
import java.util.Collections;
class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> queue;  // ArrayList to hold the queue elements

    public PriorityQueue() {
        queue = new ArrayList<>();  // Initialize the queue
    }

    // Add an element to the queue
    public void enqueue(T element) {
        queue.add(element);
        Collections.sort(queue);  // Sort the queue to maintain priority
    }

    // Remove and return the highest priority element
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue is empty. Cannot dequeue.");
        }
        return queue.remove(0);  // Remove the element with the highest priority (smallest value)
    }

    // Peek at the highest priority element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue is empty. Cannot peek.");
        }
        return queue.get(0);  // Return the element with the highest priority
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return queue.size();
    }
}