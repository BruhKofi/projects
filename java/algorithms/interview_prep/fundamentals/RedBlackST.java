/*
  Implementation of Red Black tree with left-leaning red links
*/
import java.util.NoSuchElementException;
public class RedBlackST<Key extends Comparable<Key>, Value>
{
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

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private void flipColors(Node x) {
        x.color = RED;
        x.left.color = BLACK;
        x.right.color = BLACK;
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
        x.color = h.color;
        h.color = RED;
        h.N = x.N;
        x.N = 1 + size(x.left) + size(x.right);
        return h;
    }

    private Node moveRedLeft(Node x) {
        flipColors(x);
        if (isRed(x.right.left)) {
            x.right = rotateLeft(x.right);
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
        root.color = BLACK;//Always keep root black
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
        root.color = BLACK;//Always keep root black
    }

    private Node delMax(Node x) {
        if (isRed(x.left)) x = rotateRight(x);
        if (x.right == null) return null;
        if (!isRed(x.right) && !isRed(x.right.left)) x = moveRedRight(x);
        x.right = delMax(x.right);
        return balance(x);
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        return null;
    }
        
}
