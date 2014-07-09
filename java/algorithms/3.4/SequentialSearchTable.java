public class SequentialSearchTable<Key, Value>
{
    private Node first;
    private int N;

    private class Node
    {
        Key key;
        Value val;
        Node next;

        public Node(Key k, Value v, Node n) {
            key = k; val = v; next = n;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }
    
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        Node oldFirst = first;
        first = new Node(key, val, oldFirst);
    }

    public void delete(Key key) {
        if (isEmpty()) return;
        if (key.equals(first.key)) {
            first = first.next;
            return;
        }
        for (Node x = first; x.next != null; x = x.next) {
            if (key.equals(x.next.key)) {
                x.next = x.next.next;
                return;
            }
        }
    }
            

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) q.enqueue(x.key);
        return q;
    }
}
