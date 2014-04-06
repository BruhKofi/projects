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

    public Key floor(Key key) {
        return floor(root, key, root.key);
    }

    public Key ceil(Key key) {
        return ceil(root, key, root.key);
    }

    private Key floor(Node x, Key key, Key candidate) {
        if (x == null) return key.compareTo(candidate) > 0 ? candidate : null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            if (candidate.compareTo(x.key) < 0) {
                return floor(x.right, key, x.key);
            }
            return floor(x.right, key, candidate);
        }
        if (cmp < 0) return floor(x.left, key, candidate);
        else return x.key;
    }

    private Key ceil(Node x, Key key, Key candidate) {
        if (x == null) return key.compareTo(candidate) < 0 ? candidate : null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return ceil(x.right, key, candidate);
        else if (cmp < 0) {
            if (candidate.compareTo(x.key) < 0) {
                return ceil(x.left, key, x.key);
            }
            return ceil(x.left, key, candidate);
        }
        else return x.key;
    }

    public SET union(SET<Key> that) {
        SET<Key> set = new SET<Key>();
        for (Key key : this) {
            set.add(key);
        }
        for (Key key : that) {
            if (!set.contains(key)) set.add(key);
        }
        return set;
    }

    public SET intersection(SET<Key> that) {
        SET<Key> set = new SET<Key>();
        for (Key key : that) {
            if (this.contains(key)) set.add(key);
        }
        return set;
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
        // for (String s : set) {
        //     StdOut.println(s);
        // }
        StdOut.println(set.floor("c") + " " + set.ceil("d"));
    }
}

