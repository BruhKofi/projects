import java.util.Iterator;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class Deque<Item> implements Iterable<Item>
{
    private int N;
    private Node first;
    private Node last;

    private class Node
    {
        Item item;
        Node prev;
        Node next;
    }

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    public void pushLeft(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (isEmpty()) last = first;
        else oldFirst.prev = first;
        N++;
    }

    public void pushRight(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item popLeft() {
        if (isEmpty()) throw new NoSuchElementException("Cannot pop from empty deque");
        Item item = first.item;
        Node second = first.next;
        first = second;
        first.prev = null;
        N--;
        return item;
    }

    public Item popRight() {
        if (isEmpty()) throw new NoSuchElementException("Cannot pop from empty deque");
        Item item = last.item;
        Node secLast = last.prev;
        last = secLast;
        last.next = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>
    {
        private Node current = first;
        private int size = N;

        public boolean hasNext() { return current != null; }

        public Item next() {
            if (size != N) throw new ConcurrentModificationException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();

        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("r".equals(s)) deque.pushRight(StdIn.readString());
            else if ("l".equals(s)) deque.pushLeft(StdIn.readString());
            else if ("-".equals(s)) StdOut.println(deque.popLeft());
            else if ("*".equals(s)) StdOut.println(deque.popRight());
            else {}
        }

        for (String s : deque) {
            StdOut.println(s);
        }
    }
}
