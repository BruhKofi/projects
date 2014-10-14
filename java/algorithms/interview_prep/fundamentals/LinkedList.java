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
        first = reverse(first);
    }
    
    private Node reverse(Node x) {
        if (x == null) return null;
        if (x.next == null) return x;
        Node second = x.next;
        Node tail = reverse(second);
        second.next = x;
        x.next = null;
        return tail;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i<N; i++) list.push(i);
        for (Integer i : list) {
            StdOut.println(i);
        }
        StdOut.println();
        list.reverse();
        for (Integer i : list) {
            StdOut.println(i);
        }
    }
}
