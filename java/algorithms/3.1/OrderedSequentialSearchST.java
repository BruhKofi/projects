import java.util.NoSuchElementException;
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value>
{
    private int N;
    private Node first;

    private class Node
    {
        Key key;
        Value value;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        N++;
        Node x = first;
        while (x != null && key.compareTo(x.key) < 0) {
            if (x.next != null && (key.compareTo(x.next.key) == 0)) {
                x.next.value = value;
                return;
            } else if (x.next != null && (key.compareTo(x.next.key) > 0)) {
                Node node = new Node();
                node.key = key;
                node.value = value;
                node.next = x.next;
                x.next = node;
                return;
            }
            x = x.next;
        }
        Node oldFirst = first;
        first = new Node();
        first.key = key;
        first.value = value;
        first.next = oldFirst;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) == 0) return x.value;
        }
        return null;
    }

    public void delete(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) == 0) {
                x.value = null;
                N--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.compareTo(x.key) == 0) return true;
        }
        return false;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.key;
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = first;
        while (x.next != null) x = x.next;
        return x.key;
    }

    public Key floor(Key key) {
        Node x = first;
        while (x != null) {
            if (x.next != null && key.compareTo(x.next.key) > 0) return x.next.key;
        }
        throw new NoSuchElementException();
    }

    public Key ceiling(Key key) {
        Node x = first;
        while (x != null && key.compareTo(x.key) < 0) x = x.next;
        return x.key;
    }

    public int rank(Key key) {
        int i = 0;
        Node x = first;
        while (x != null) {
            i++;
            if (key.compareTo(x.key) == 0) return i;
        }
        throw new NoSuchElementException();
    }

    public Key select(int k) {
        int i = 0;
        for (Node x = first; x != null && i < k; x = x.next) {
            if (++i == k) return x.key;
        }
        throw new NoSuchElementException();
    }

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (rank(hi) < rank(lo)) throw new NoSuchElementException();
        Queue<Key> q = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            if (lo.compareTo(x.key) <= 0 && hi.compareTo(x.key) >= 0)
                q.enqueue(x.key);
        }
        return q;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            q.enqueue(x.key);
        }
        return q;
    }
}
    