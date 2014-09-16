public class HybridTST<Value>
{
    private static final int R = 256;
    private static Node[] root = new Node[R];
    private int N;

    private static class Node
    {
        private char c;
        private Node left, mid, right;
        private Object val;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(String key, Value val) {
        if (key == null || key.isEmpty()) throw new IllegalArgumentException("Key must be a non-empty String");
        if (!contains(key)) N++;
        char c = key.charAt(0);
        if (root[c] == null) root[c] = new Node();
        root[c].c = c;
        if (key.length() == 1) {
            root[c].val = val;
        } else {
            root[c] = put(root[c], key, val, 1);
        }
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d+1);
        else x.val = val;
        return x;
    }

    public Value get(String key) {
        if (key == null || key.isEmpty()) throw new IllegalArgumentException("Key must be a non-empty String");
        char c = key.charAt(0);
        Node x = root[c];
        if (key.length() > 1) x = get(root[c], key, 1);
        if (x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length()-1) return get(x.mid, key, d+1);
        else return x;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Iterable<String> keys() {
        Queue<String> q = new Queue<String>();
        for (char c = 0; c<R; c++) {
            traverse(root[c], String.valueOf(c), q);
        }
        return q;
    }

    private void traverse(Node x, String m, Queue<String> q) {
        if (x == null) return;
        traverse(x.left, m, q);
        if (x.val != null) q.enqueue(m + x.c);
        traverse(x.mid, m + x.c, q);
        traverse(x.right, m, q);
    }

    public static void main(String[] args) {
        HybridTST<Integer> tst = new HybridTST<Integer>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (tst.contains(s)) tst.put(s, tst.get(s) + 1);
            else tst.put(s, 1);
        }
        for (String s : tst.keys()) {
            StdOut.println(s + ": " + tst.get(s));
        }
    }
}
