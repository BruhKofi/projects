import java.util.Iterator;
import java.lang.UnsupportedOperationException;

public class MySET<Key extends Comparable<Key>> implements Iterable<Key>
{
    private Node root;

    private class Node
    {
        Node(Key key) {
            this.key = key;
        }
        Key key;
        Node left;
        Node right;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Key key) {
        root = add(root, key);
    }

    private Node add(Node x, Key key) {
        if (x == null) return new Node(key);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = add(x.left, key);
        if (cmp > 0) x.right = add(x.right, key);
        else x.key = key;
        return x;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private Key get(Key key) {
        return get(root, key);
    }

    private Key get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        if (cmp > 0) return get(x.right, key);
        else return x.key;
    }

    public MySETIterator iterator() {
        return new MySETIterator();
    }

    private class MySETIterator implements Iterator<Key>
    {
        Stack<Node> stack = new Stack<Node>();

        MySETIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node x) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Key next() {
            Node x = stack.pop();
            pushLeft(x.right);
            return x.key;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

        

    public static void main(String[] args) {
        MySET<String> set = new MySET<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!set.contains(s)) {
                set.add(s);
            }
        }
        for (String s : set) {
            StdOut.println(s);
        }
    }
}

