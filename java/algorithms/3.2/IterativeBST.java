import java.util.NoSuchElementException;
public class IterativeBST<Key extends Comparable<Key>, Value>
{
    private Node root;
    private int N;
    
    private class Node
    {
        private Key key;
        private Value val;
        private Node left;
        private Node right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (root == null) root = new Node(key, value);
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                if (x.left == null) {
                    x.left = new Node(key, value);
                    return;
                }
                x = x.left;
            }
            else if (cmp > 0) {
                if (x.right == null) {
                    x.right = new Node(key, value);
                    return;
                }
                x = x.right;
            }
            else {
                x.val = value;
                return;
            }
        }
    }

    public boolean contains(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return true;
        }
        return false;
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
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        return x;
    }

    public Key min() {
        Node x =  min(root);
        if (x == null) return null;
        return x.key;
    }

    public Key max() {
        Node x = max(root);
        if (x == null) return null;
        return x.key;
    }

    private Node min(Node x) {
        if (root == null) throw new NoSuchElementException();
        while (x.left != null) x = x.left;
        return x;
    }

    private Node max(Node x) {
        if (root == null) throw new NoSuchElementException();
        while (x.right != null) x = x.right;
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        keys(root, q, min(), max());
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
        NoCntBST<String, Integer> bst = new NoCntBST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            bst.put(StdIn.readString(), i);
        }
        for (String key : bst.keys()) {
            StdOut.println(key + " " + bst.get(key));
        }
    }
}
