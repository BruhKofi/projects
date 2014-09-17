import java.util.NoSuchElementException;
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

        public String toString() {
            return c + ": " + val;
        }
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

    public String firstKey() {
        if (isEmpty()) throw new NoSuchElementException("symbol table is empty");
        StringBuilder sb = new StringBuilder();
        char c = 0;
        while (root[c] == null) c++;
        min(root[c], sb);
        return sb.toString();
    }

    private void min(Node x, StringBuilder sb) {
        if (x == null) return;
        if (x.left != null) min(x.left, sb);
        sb.append(x.c);
        if (x.mid != null) min(x.mid, sb);
        if (x.right != null) min(x.right, sb);
    }

    public String lastKey() {
        if (isEmpty()) throw new NoSuchElementException("symbol table is empty");
        StringBuilder sb = new StringBuilder();
        char c = R-1;
        while (root[c] == null) c--;
        max(root[c], sb);
        return sb.toString();
    }

    private void max(Node x, StringBuilder sb) {
        if (x == null) return;
        if (x.right != null) max(x.right, sb);
        sb.append(x.c);
        if (x.mid != null) max(x.mid, sb);
        if (x.left != null) max(x.left, sb);
    }

    public void delete(String key) {
        if (key == null || key.isEmpty()) throw new IllegalArgumentException("Key must be a non-empty String");
        char c = key.charAt(0);
        root[c] = delete(root[c], key, 1);
    }

    private Node delete(Node x, String key, int d) {
        StdOut.println(x + ": " + x.left + ": " + x.mid + ": " + x.right);
        if (x == null) return null;
        if (d == key.length()) {
            if (x.val != null) N--;
            x.val = null;
        } else {
            char c = key.charAt(d);
            if (c < x.c) x.left = delete(x.left, key, d);
            else if (c > x.c) x.right = delete(x.right, key, d);
            else x.mid = delete(x.mid, key, d+1);
        }
        //        StdOut.println(x);
        if (x.val != null || x.mid != null) return x;
        if (x.left == null) return x.right;
        if (x.right == null) return x.left;
        if (x.right != null && x.left != null) {
            if (x.right.c - x.c > x.c - x.left.c) return x.left;
            else return x.right;
        }
        return null;
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
        //        for (String s : tst.keys()) StdOut.println(s + ": " + tst.get(s));
        StdOut.println();
        tst.delete("sea");
        //        for (String t : tst.keys()) StdOut.println(t + ": " + tst.get(t));
    }
}
