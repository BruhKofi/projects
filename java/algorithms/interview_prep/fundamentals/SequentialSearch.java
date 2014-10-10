/*
  Implmenetation of sequential search symbol table
  To be used in hashing with separate chaining
*/
import java.util.NoSuchElementException;
public class SequentialSearch<Key, Value>
{
    private int N;
    private Node first;

    // Use linked list
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
            if (key.equals(x.key)) {
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
        return get(key) != null;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void delete(Key key) {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        if (key.equals(first.key)) first = first.next;
        else {
            for (Node x = first; x.next != null; x = x.next) {
                if (key.equals(x.next.key)) {
                    x.next = x.next.next;
                    return;
                }
            }
        }
    }
}
