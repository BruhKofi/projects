/*
  Elementary linked list implementation with stack API
*/
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item>
{
    private Node first;
    private int N;

    private class Node
    {
        private Item item;
        private Node next;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item  = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void sort() {
    }

    public void reverse() {
    }
}
