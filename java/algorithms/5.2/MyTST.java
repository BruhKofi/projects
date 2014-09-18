public class MyTST<Value>
{
    private Node root;

    private class Node
    {
        private char c;
        private Node left, mid, right;
        private Value val;
        private int N;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() -1) return get(x.mid, key, d+1);
        else return x;
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
                x = new Node();
                x.c = c;
        }
        if (c < x.c) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() -1) x.mid = put(x.mid, key, val, d+1);
        else {
            if (x.val == null) x.N++;
            x.val = val;
        }
        x.N = size(x.left) + size(x.mid) + size(x.right);
        if (x.val != null) x.N++;
        return x;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public boolean contains(String s) {
        return get(s) != null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        StdOut.println(length);
        return s.substring(0, length);
    }

    private int search(Node x, String pre, int d, int length) {
        if (x == null) return length;
        if (x.val != null) {
            d++;
            length = d;
        }
        if (d == pre.length()) return length;
        char c = pre.charAt(d);
        if (c < x.c) return search(x.left, pre, d, length);
        else if (c > x.c) return search(x.right, pre, d, length);
        else return search(x.mid, pre, d+1, length);
    }

    public static void main(String[] args) {
        MyTST<Integer> t = new MyTST<Integer>();
        String[] a = (new In(args[0])).readAll().split("\\s+");
        int i = 0;
        for (String s : a) {
            t.put(s, i++);
            StdOut.println(t.size());
        }
    }
}
