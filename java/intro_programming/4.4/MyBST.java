public class MyBST<Key extends Comparable<Key>, Value>
{
    private Node root;

    private class Node
    {
        Key key;
        Value value;
        int subTreeSize;
        Node left, right;
        Node(Key key, Value value, int subTreeSize) {
            this.key = key; this.value = value; this.subTreeSize = subTreeSize;
        }
    }

    public int size() {
        return root.subTreeSize + 1;
    }

    public Key min() {
        return min(root);
    }

    public Key max() {
        return max(root);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return get(x.right, key);
        else if (cmp < 0) return get(x.left, key);
        else return x.value;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 0);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.subTreeSize++;
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.subTreeSize++;
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    private Key min(Node x) {
        if (x == null) return null;
        if (x.left == null) return x.key;
        return min(x.left);
    }

    private Key max(Node x) {
        if (x == null) return null;
        if (x.right == null) return x.key;
        return max(x.right);
    }
        

    public static void main(String[] args) {
        MyBST<String, String> st = new MyBST<String, String>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            String value = StdIn.readString();
            st.put(key, value);
        }
        StdOut.println(st.size());
        StdOut.println(st.min());
        StdOut.println(st.max());
    }
}
