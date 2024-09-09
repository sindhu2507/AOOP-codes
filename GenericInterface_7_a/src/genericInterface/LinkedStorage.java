package genericInterface;

class LinkedStorage<T> implements Storage<T> {
    private ListNode<T> top;  // Reference to the top of the stack

    public LinkedStorage() {
        this.top = null;
    }

    @Override
    public void add(T element) {
        ListNode<T> newNode = new ListNode<>(element);
        newNode.next = top;  // Point new node to the previous top
        top = newNode;       // Update the top
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Storage is empty. Cannot remove.");
        }
        T removedElement = top.data;
        top = top.next;  // Move the top to the next node
        return removedElement;
    }

    @Override
    public T viewTop() {
        if (isEmpty()) {
            throw new RuntimeException("Storage is empty. Cannot view top.");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}