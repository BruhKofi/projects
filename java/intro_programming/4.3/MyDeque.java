import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;

public class MyDeque<Item> implements Iterable<Item>
{
    private Node first;
    private Node last;

    private class Node
    {
        Item item;
        Node next;
        Node previous;
    }
    
    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        if (last == null) {
            last = new Node();
            last.item = item;
            first = last;
        } else {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.previous = oldLast;
            oldLast.next = last;
        }
    }

    public void push(Item item) {
        if (first == null) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            oldFirst.previous = first;
        }
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        return item;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        last = last.previous;
        last.next = null;
        return item;
    }

    public MyDequeIterator iterator() {
        return new MyDequeIterator();
    }

    private class MyDequeIterator implements Iterator<Item>
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
        

    public static void main(String[] args) {
        MyDeque<String> d =  new MyDeque<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.println(d.pop());
            } else {
                d.enqueue(s);
            }
        }
        for (String s : d) {
            StdOut.println(s);
        }
    }
}
        
