import java.util.NoSuchElementException;
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

    public static void main(String[] args) {
        MyBST<Integer, String> st = new MyBST<Integer, String>();
        for (int i = 0; i<3; i++) {
            st.put(i, "hello");
        }
        while (!StdIn.isEmpty()) {
            int j = StdIn.readInt();
            st.delete(j);
            for (int i : st.keys()) StdOut.println(i + ": " + st.get(i));
        }
    }
}
