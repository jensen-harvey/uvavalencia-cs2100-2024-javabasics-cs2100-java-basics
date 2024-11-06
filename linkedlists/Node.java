package linkedlists;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev; // New field for previous node reference

    public Node() {}

    public Node(T val) {
        this.data = val;
    }

    public Node(T val, Node<T> next, Node<T> prev) {
        this.data = val;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
