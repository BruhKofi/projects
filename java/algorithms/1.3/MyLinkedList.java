import java.util.Iterator;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class MyLinkedList<Item> implements Iterable<Item>
{
    private int N;
    private Node first;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean contains(Item item) {
        for (Node current = first; current != null; current = current.next) {
            if (item.equals(current.item)) return true;
        }
        return false;
    }

    public void remove(Item item) {
        if (first == null) throw new NoSuchElementException();
        if (item.equals(first.item)) first = first.next;
        for (Node current = first; current != null; current = current.next) {
            if (current.next != null && item.equals(current.next.item)) {
                current.next = current.next.next;
                return;
            }
        }
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Iterator<Item> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<Item>
    {
        private Node current = first;
        private int size = N;

        public boolean hasNext() {
            if (size != N) throw new ConcurrentModificationException();
            return current != null;
        }

        public Item next() {
            if (size != N) throw new ConcurrentModificationException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
 }