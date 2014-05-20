public class LinkedPQ<Key extends Comparable<Key>>
{
    private Node max;
    private int N;

    private class Node
    {
        Key key;
        Node top;
        Node left;
        Node right;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        if (isEmpty()) {
            max = new Node();
            max.key = key;
            StdOut.println(max.key);
        } else {
            Node x = max;
            while (x.left != null) {
                x = x.left;
            }
            Node newNode = x.left;
            newNode.key = key;
            newNode.top = x;
            StdOut.println(newNode.key);
            swim(newNode);
        }
    }

    public Key delMax() {
        Key value = max.key;
        max = max.left;
        if (max != null) sink(max);
        return value;
    }

    private void sink(Node x) {
        StdOut.println(x);
        while (x.left != null || x.right != null) {
            if (x.right != null && x.left == null) {
                if (!less(x, x.right)) return;
                exch(x, x.right);
                x = x.right;
            }
            else if (x.left != null && x.right == null) {
                if (!less(x, x.left)) return;
                exch(x, x.left);
                x = x.left;
            }
            else {
                Node min = less(x.left, x.right) ? x.left : x.right;
                if (!less(x, min)) return;
                exch(x, min);
                x = min;
            }
        }
    }

    private void swim(Node x) {
        while (x.top != null && less(x, x.top)) {
            exch(x, x.top);
            x = x.top;
            StdOut.println(x.key);
        }
    }

    private void exch(Node x, Node y) {
        Key t = x.key;
        x.key = y.key;
        y.key = t;
    }

    private boolean less(Node x, Node y) {
        if (x == null || y == null) throw new NullPointerException();
        return x.key.compareTo(y.key) < 0;
    }

    public static void main(String[] args) {
        LinkedPQ<String> pq = new LinkedPQ<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("*".equals(s)) pq.delMax();
            else pq.insert(s);
        }
    }
}