import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
public class MySequentialSearchST<Key, Value>
{
    private Node first;
    private int N;

    private class Node
    {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key; this.val = val; this.next = next;
        }
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) return true;
        }
        return false;
    }

    public void delete(Key key) {
        if (isEmpty()) throw new NoSuchElementException("Symbol table is empty");
        if (first.key.equals(key)) {
            first = first.next;
            N--;
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (x.next == null) continue;
            if (x.next.key.equals(key)) {
                x.next = x.next.next;
                N--;
                return;
            }
        }
        throw new NoSuchElementException("Key not found in symbol table");
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) return x.val;
        }
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) q.enqueue(x.key);
        return q;
    }
    
    public static void main(String[] args) {
        MySequentialSearchST<String, Integer> st = new MySequentialSearchST<String, Integer>();
        int i = 0;
        while (!StdIn.isEmpty()) st.put(StdIn.readString(), i++);
        StdOut.println(st.get("hello"));
        StdOut.println(st.contains("me"));
        StdOut.println(st.contains("hello"));
        while (!st.isEmpty()) {
            StdOut.println(st.size());
            String t = "";
            for (String s : st.keys()) t = s;
            st.delete(t);
        }
    }
}
            
            
