import java.util.NoSuchElementException;
import java.util.Iterator;
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

    // Returns true if the symbol table is empty
    public boolean isEmpty() {
        return N == 0;
    }

    // Returns the number of key-value mappings in the symbol table
    public int size() {
        return N;
    }

    // Adds the key-value pair to the symbol table if not already present
    // Updates the value corresponding to the key, if the key is in the table already
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

    // Returns the value mapped to the given key.  Returns null if they key is not in the table.
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

    // Returns true if the symbol table contains the given key
    public boolean contains(String key) {
        return get(key) != null;
    }

    // Returns the minimum key in the symbol table (follows standard Java ordering for Strings)
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

    // Returns the maximum key in the symbol table (follows standard Java ordering for Strings)
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

    // Removes the key (and corresponding value) from the symbol table
    public void delete(String key) {
        if (key == null) throw new NullPointerException("Null keys are disallowed");
        if (key.isEmpty()) throw new IllegalArgumentException("Key must be a non-empty String");
        char c = key.charAt(0);
        root[c] = delete(root[c], key, 1);
    }

    private Node delete(Node x, String key, int d) {
        StdOut.println(x);
        if (x == null) return null;
        if (d == key.length()-1) {
            if (x.val != null) N--;
            x.val = null;
        }
        else {
            char c = key.charAt(d);
            if (c < x.c) x.left = delete(x.left, key, d);
            else if (c > x.c) x.right = delete(x.right, key, d);
            else if (d < key.length()-1) x.mid = delete(x.mid, key, d+1);
        }
        if (x.val != null) return x;
        if (x.left != null || x.mid != null || x.right != null) return x;
        return null;
    }

    // Returns an Iterable object that contains all the keys in the table
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

    // Test client
    public static void main(String[] args) {
        HybridTST<Integer> tst = new HybridTST<Integer>();
        assert(tst.isEmpty());

        // Build table from standard input
        // Test contains(String key), isEmpty(), put(String key, Value val), get(String key), size()
        {
            while (!StdIn.isEmpty()) {
                String s = StdIn.readString();
                if (tst.contains(s)) {
                    int N = tst.size();
                    int m = tst.get(s);
                    tst.put(s, m + 1);
                    assert(tst.size() == N);
                    assert(tst.get(s) == m+1);
                }
                else {
                    int N = tst.size();
                    tst.put(s, 1);
                    assert(tst.size() == N+1);
                    assert(tst.contains(s));
                    assert(tst.get(s) == 1);
                }
            }
        }
        
        // Check that we iterate in natural order
        // Test keys(), firstKey(), lastKey()
        {
            Iterator<String> itr = tst.keys().iterator();
            int i = 0;
            int k = tst.size();
            while (itr.hasNext()) {
                String s = itr.next();
                if (i == 0) assert(s.equals(tst.firstKey()));
                else if (i == k-1) assert(s.equals(tst.lastKey()));
                assert(tst.contains(s));
                i++;
            }
        }

        // Check delete(String key), firstKey(), lastKey()
        {
            while (!tst.isEmpty()) {
                int k = tst.size();
                String f = tst.firstKey();
                String l = tst.lastKey();
                StdOut.println(l);
                tst.delete(l);
                for (String s : tst.keys()) StdOut.print(s + " ");
                StdOut.println();
                assert(!tst.contains(l));
                assert(tst.size() == k-1);
                assert(tst.firstKey().equals(f));
            }
        }
    }
}
