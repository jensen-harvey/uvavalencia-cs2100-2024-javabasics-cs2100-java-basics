package linkedlists;

import java.util.Iterator;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a new element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data, null, tail);
        if (tail != null) {
            tail.setNext(newNode);
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    // Remove an element from the list (first occurrence)
    public void remove(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                if (current.getPrev() != null) {
                    current.getPrev().setNext(current.getNext());
                } else {
                    head = current.getNext();
                }

                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                } else {
                    tail = current.getPrev();
                }

                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(" <-> ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
    
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }
}
