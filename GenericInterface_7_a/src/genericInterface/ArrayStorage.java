package genericInterface;

class ArrayStorage<T> implements Storage<T> {
    private T[] storage;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStorage(int capacity) {
        this.capacity = capacity;
        this.storage = (T[]) new Object[capacity];  // Initialize array
        this.top = -1;  // Storage is initially empty
    }

    @Override
    public void add(T element) {
        if (top == capacity - 1) {
            throw new RuntimeException("Storage is full. Cannot add.");
        }
        storage[++top] = element;  // Increment top and add element
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Storage is empty. Cannot remove.");
        }
        return storage[top--];  // Remove the top element and decrement top
    }

    @Override
    public T viewTop() {
        if (isEmpty()) {
            throw new RuntimeException("Storage is empty. Cannot view top.");
        }
        return storage[top];  // Return top element without removing it
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
