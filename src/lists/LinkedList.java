package lists;

import interfaces.IteratorInterface;
import interfaces.ListInterface;
import iterators.LinkedListIterator;

public class LinkedList implements ListInterface {
    public class Node {
        public Object value;
        public Node next;

        public Node(Object v) {
            value = v;
            next = null;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public LinkedList() {
        clear();
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if (size > 0) {
            last.next = newNode;
            newNode.next = null;
            last = newNode;
        } else {
            newNode.next = null;
            first = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks do dodania: " + index + " dla listy o rozmiarze: " + size);
        }
        Node newNode = new Node(value);
        if (index == 0) {
            if (isEmpty()) {
                first = newNode;
                newNode.next = null;
                last = newNode;
            } else {
                newNode.next = first;
                first = newNode;
            }
        }
        if (index > 0) {
            Node node = first;
            int i = 1;
            while (i + 1 < index) {
                node = node.next;
                i++;
            }
            if (node.next == null) {
                last = newNode;
                node.next = newNode;
                newNode.next = null;
            } else {
                newNode.next = node.next;
                node.next = newNode;
            }

        }
        size++;
    }
    @Override
    public void set(Object value, int index) throws IndexOutOfBoundsException
    {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks do ustawienia: " + index + " dla listy o rozmiarze: " + size);
        }
        Node node = first;

        int i = 1;
        while (i+1 < index) {
            node = node.next;
            i++;
        }
        node.next.value = value;
    }

    @Override
    public Object get(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks do uzyskania: " + index + " dla listy o rozmiarze: " + size);
        }
        Node node = first;

        int i = 1;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node.value;
    }

    @Override
    public Object remove(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks do usunięcia: " + index + " dla listy o rozmiarze: " + size);
        }

        Node toRemoved;
        if (index == 1) {
            toRemoved = first;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node node = first;
            int i = 1;
            while (i+1 < index) {
                node = node.next;
                i++;
            }
            toRemoved = node.next;
            node.next = node.next.next;
            if (node.next == null) {
                last = node;
            }
        }
        size--;
        return toRemoved.value;
    }

    @Override
    public boolean contain(Object value) {
        IteratorInterface it = getIterator();
        for (it.last(); !it.isDone(); it.previous()) {
             if(it.current() == value){
                 return true;
             }
        }
        return false;
    }

    public IteratorInterface getIterator()
    {
        return new LinkedListIterator(this);
    }

    @Override
    public String toString()
    {
        String buffer = "";
//        Node node = first;
//
//        while (node != null) {
//            buffer += node.value.toString() + " -> ";
//            node = node.next;
//        }
        IteratorInterface it = getIterator();
        for (it.first(); !it.isDone(); it.next()) {
            buffer += it.current() + " -> ";
        }
        buffer += "null";
        return buffer;
    }
}
