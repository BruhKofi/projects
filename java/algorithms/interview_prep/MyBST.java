import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;
public class MyBST<Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node
    {
        private Key key;
        private Value val;
        private int N;
        private Node left, right;

        public Node(Key key, Value val) {
                this.key = key; this.val = val;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) x = new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key) {
        Node x = get(root, key);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        Node x = min(root);
        return x.key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        Node x = max(root);
        return x.key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        keys(root, q, min(), max());
        return q;
    }

    private void keys(Node x, Queue<Key> q, Key min, Key max) {
        if (x == null) return;
        int cmplo = min.compareTo(x.key);
        int cmphi = max.compareTo(x.key);
        if (cmplo < 0) keys(x.left, q, min, max);
        if (cmplo <= 0 && cmphi >= 0) q.enqueue(x.key);
        if (cmphi > 0) keys(x.right, q, min, max);
    }

    public void delMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        root = delMin(root);
    }

    private Node delMin(Node x) {
        if (x.left == null) return x.right;
        x.left = delMin(x.left);
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        root = delMax(root);
    }

    private Node delMax(Node x) {
        if (x.right == null) return x.left;
        x.right = delMax(x.right);
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = min(x.right);
            t.right = delMin(x.right);
            t.left = x.left;
            x = t;
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) throw new NoSuchElementException("Key not in symbol table");
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    public Key select(int k) {
        if (isEmpty()) throw new NoSuchElementException("Cannot select key from empty table");
        if (k < 0 || k >= size()) throw new IndexOutOfBoundsException("Value must be between 0 and " + (size()-1));
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) throw new NullPointerException("Cannot access null node");
        int sz = size(x.left);
        if (sz > k) return select(x.left, k);
        else if (sz < k) return select(x.right, k-sz-1);
        else return x;
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return floor(x.left, key);
        else if (cmp > 0) {
            Node t = floor(x.right, key);
            if (t != null) return t;
        }
        return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return ceiling(x.right, key);
        else if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
        }
        return x;
    }

    public static void main(String[] args) {
        MyBST<String, Integer> st = new MyBST<String, Integer>();
        int i = 0;
        while (!StdIn.isEmpty()) st.put(StdIn.readString(), i++);
        for (String s : st.keys()) StdOut.println(s);
        StdOut.println();
        StdOut.println(st.ceiling("hi"));
        StdOut.println(st.ceiling("isa"));
        StdOut.println(st.ceiling("world"));
        StdOut.println(st.ceiling("btiar"));
    }
}
