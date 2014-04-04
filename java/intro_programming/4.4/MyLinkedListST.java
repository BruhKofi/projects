import java.util.Iterator;
import java.lang.UnsupportedOperationException;

public class MyLinkedListST<Key extends Comparable<Key>, Value> implements Iterable<Key>
{
    int N;
    private Node first;
    
    private class Node
    {
        Key key;
        Value value;
        Node next;
    }

    public void put(Key key, Value value) {
        Node oldFirst = first;
        first = new Node();
        first.key = key;
        first.value = value;
        first.next = oldFirst;
    }

    public Value get(Key key) {
        for (Node current = first; current != null; current = current.next) {
            if (key.equals(current.key)) return current.value;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public MyLinkedListSTIterator iterator() {
        return new MyLinkedListSTIterator();
    }

    private class MyLinkedListSTIterator implements Iterator<Key>
    {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Key next() {
            Key key = current.key;
            current = current.next;
            return key;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        int minocc = Integer.parseInt(args[1]);
        
        String[] words = StdIn.readAll().split("\\s+");

        MyLinkedListST<String, Queue<Integer>> st = new MyLinkedListST<String, Queue<Integer>>();
        
        for (int i = 0; i<words.length; i++) {
            String s = words[i];
            if (s.length() < minlen) continue;
            if (!st.contains(s)) st.put(s, new Queue<Integer>());
            Queue<Integer> q = st.get(s);
            q.enqueue(i);
        }

        for (String s : st) {
            Queue<Integer> q = st.get(s);
            if (q.size() >= minocc) StdOut.println(s + ": " + q);
        }
    }
}