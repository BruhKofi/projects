import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

public class MoveToFrontList<Item> implements Iterable<Item>
{
    private Node first;
    private int size;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        size++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public int contains(Item item) {
        int i = 0;
        for (Node current = first; current != null; current = current.next) {
            i++;
            if (item.equals(current.item)) return i;
        }
        return -1;
    }

    public Item delete(int i) {
        if (size < i) throw new NoSuchElementException();
        size--;
        if (i == 1) return delete();
        Node current = first;
        int link = 1;
        while (link < i-1 && current != null) {
            current = current.next;
            link++;
        }
        Node delete = current.next;
        Item item = delete.item;
        current.next = delete.next;
        delete = null;
        return item;
    }

    private Item delete() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public MoveToFrontListIterator iterator() {
        return new MoveToFrontListIterator();
    }

    private class MoveToFrontListIterator implements Iterator<Item>
    {
        Node current = first;

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

}
