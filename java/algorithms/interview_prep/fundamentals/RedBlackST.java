/*
  Implementation of Red Black tree with left-leaning red links
*/
import java.util.NoSuchElementException;
public class RedBlackST<Key extends Comparable<Key>, Value>
{
    // Class variables
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int N;

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key; this.val = val; this.N = N; this.color = color;
        }
    }

    // Helpers
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private void flipColors(Node x) {
        x.color = !x.color;
        x.left.color = !x.left.color;
        x.right.color = !x.right.color;
    }

    private Node rotateLeft(Node x) {
        Node h = x.right;
        x.right = h.left;
        h.left = x;
        h.color = x.color;
        x.color = RED;
        h.N = x.N;
        x.N = 1 + size(x.left) + size(x.right);
        return h;
    }

    private Node rotateRight(Node x) {
        Node h = x.left;
        x.left = h.right;
        h.right = x;
        h.color = x.color;
        x.color = RED;
        h.N = x.N;
        x.N = 1 + size(x.left) + size(x.right);
        return h;
    }

    private Node moveRedLeft(Node x) {
        flipColors(x);
        if (isRed(x.right.left)) {
            x.right = rotateRight(x.right);
            x = rotateLeft(x);
        }
        return x;
    }

    private Node moveRedRight(Node x) {
        flipColors(x);
        if (isRed(x.left.left)) x = rotateRight(x);
        return x;
    }

    private Node balance(Node x) {
        if (isRed(x.right)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /*
      Begin public API
    */
    //Standard symbol table operations
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1, RED);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        //Balance on way back up the tree
        if (isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right)) flipColors(x);
        //Update size
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

    private boolean contains(Key key) {
        return get(key) != null;
    }

    public void delMin() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delMin(root);
        if (!isEmpty()) root.color = BLACK;//Always keep root black
    }

    private Node delMin(Node x) {
        if (x.left == null) return null;
        if (!isRed(x.left) && !isRed(x.left.left)) x = moveRedLeft(x);
        x.left = delMin(x.left);
        return balance(x);
    }

    public void delMax() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delMax(root);
        if (!isEmpty()) root.color = BLACK;//Always keep root black
    }

    private Node delMax(Node x) {
        if (isRed(x.left)) x = rotateRight(x);
        if (x.right == null) return null;
        if (!isRed(x.right) && !isRed(x.right.left)) x = moveRedRight(x);
        x.right = delMax(x.right);
        return balance(x);
    }

    public void delete(Key key) {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        if (!contains(key)) return;//Should we inform client code that key is not in the table?
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;//Keep root black
    }

    private Node delete(Node x, Key key) {
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            if (!isRed(x.left) && !isRed(x.left.left)) x = moveRedLeft(x);
            x.left = delete(x.left, key);
        } else {
            if (isRed(x.left)) x = rotateRight(x);
            cmp = key.compareTo(x.key);
            if (cmp == 0 && x.right == null) return null;
            if (!isRed(x.right) && !isRed(x.right.left)) x = moveRedRight(x);
            cmp = key.compareTo(x.key);
            if (cmp == 0) {
                // Replace with successor in BST
                Node t = min(x.right);
                x.key = t.key;
                x.val = t.val;
                x.right = delMin(x.right);
            } else {
                x.right = delete(x.right, key);
            }
        }
        return balance(x);//Keep Red-Black invariant
    }

    //Ordered symbol table operations
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        Node x = min(root);
        return x.key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        Node x = max(root);
        return x.key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return -1;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    public Key select(int k) {
        if (k < 0 || k > size()-1) throw new IndexOutOfBoundsException("arg must be between 0 and " + (size()-1));
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t- 1);
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

    //Range search
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        keys(root, q, lo, hi);
        return q;
    }

    private void keys(Node x, Queue<Key> q, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, q, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) q.enqueue(x.key);
        if (cmphi > 0) keys(x.right, q, lo, hi);
    }

    public static void main(String[] args) {
        RedBlackST<String, Integer> st = new RedBlackST<String, Integer>();
        int i = 0;
        while (!StdIn.isEmpty() && i < 10) {
            String s = StdIn.readString();
            st.put(s, i++);
        }
        while (!StdIn.isEmpty()) {
            StdOut.println(st.ceiling(StdIn.readString()));
        }
    }
}
