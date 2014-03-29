import java.util.Iterator;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class MyGeneralizedQueue<Item> implements Iterable<Item>
{
    private Node first;
    int size = 0;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Item item) {
        size++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
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

    public MyGeneralizedQueueIterator iterator() {
        return new MyGeneralizedQueueIterator();
    }

    private class MyGeneralizedQueueIterator implements Iterator<Item>
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

    public static void main(String[] args) {
        MyGeneralizedQueue<String> q = new MyGeneralizedQueue<String>();
        while (!StdIn.isEmpty()) {
            q.insert(StdIn.readString());
        }
        for (String s : q) {
            StdOut.println(s);
        }
        StdOut.println();
        StdOut.println(q.delete(2));
        StdOut.println(q.delete(2));
        StdOut.println(q.delete(3));
    }
}
