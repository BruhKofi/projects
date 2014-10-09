import java.util.NoSuchElementException;
public class BinarySearchTree<Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key; this.val = val; this.N = N;
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
        if (x == null) return new Node(key, val, 1);
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

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
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
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            else {
                Node t = x;
                x = min(t.right);
                x.right = delMin(t.right);
                x.left = t.left;
            }
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
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
        if (k < 0 || k >= size()) return null;
        Node x = select(root, k);
        if (x == null) return null;
        return x.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int sz = size(x.left);
        if (sz > k) return select(x.left, k);
        else if (sz < k) return select(x.right, k - 1 - sz);
        else return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        traverse(root, q, lo, hi);
        return q;
    }

    private void traverse(Node x, Queue<Key> q, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) traverse(x.left, q, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) q.enqueue(x.key);
        if (cmphi > 0) traverse(x.right, q, lo, hi);
    }

    //Should also check order in this method
    private boolean isBST() {
        if (root == null) return true;
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key lo, Key hi) {
        if (x == null) return true;
        if (lo != null && lo.compareTo(x.key) >= 0) return false;
        if (hi != null && hi.compareTo(x.key) <= 0) return false;
        return isBST(x.left, lo, x.key) && isBST(x.right, x.key, hi);
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = ALPHABET.length();
        int cnt = 0;
        BinarySearchTree<Character, Integer> bst = new BinarySearchTree<Character, Integer>();
        for (int i = 0; i<T; i++) {
            int r = StdRandom.uniform(len);
            char c = ALPHABET.charAt(r);
            if (bst.contains(c)) bst.put(c, bst.get(c)+1);
            else {
                bst.put(c, 1);
                cnt++;
            }
        }
        assert(bst.size() == cnt);
        char c = bst.min();
        bst.delMin();
        assert(!bst.contains(c));
        c = bst.max();
        bst.delMax();
        assert(!bst.contains(c));
        do {
            c = ALPHABET.charAt(StdRandom.uniform(len));
        } while (!bst.contains(c));
        bst.delete(c);
        assert(bst.isBST());
        assert(!bst.contains(c));
        for (Character d : bst.keys()) StdOut.println(d + " " + bst.get(d));
    }
}
