import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.lang.UnsupportedOperationException;

public class MyStack<Item> implements Iterable<Item>
{
    private Node first;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public MyStack() {};

    public MyStack(MyStack<Item> s) {
        for (Item item : s) {
            push(item);
        }
        first = reverse(first);
    }

    private Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }
            
            

    public boolean isEmpty() { return first == null; }

    public int size() { return N; }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new MyStackIterator();
    }

    private class MyStackIterator implements Iterator<Item>
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

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<String>();
        for (String i : args) {
            stack.push(i);
        }

        MyStack<String> other = new MyStack(stack);

        stack.push("stack");

        for (String s : stack) {
            StdOut.println(s);
        }

        StdOut.println();

        other.push("other!");

        for (String s : other) {
            StdOut.println(s);
        }
    }
}
