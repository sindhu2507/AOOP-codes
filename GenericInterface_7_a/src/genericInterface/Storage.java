package genericInterface;

interface Storage<T> {
    void add(T element);   // Push element to the storage
    T remove();            // Remove the top element from the storage
    T viewTop();           // Peek at the top element without removing it
    boolean isEmpty();     // Check if the storage is empty
}
