import java.util.NoSuchElementException;
public class MyTrieSet
{
    private Node root;
    private int N;
    private static final int R = 256;

    private static class Node
    {
        private int endOfString = 0;
        private Node[] next = new Node[R];
    }

    public void add(String key) {
        if (contains(key)) return;
        root = add(root, key, 0);
    }

    private Node add(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (key.length() == d) {
            N++;
            x.endOfString = -1;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = add(x.next[c], key, d+1);
        return x;
    }

    public void delete(String key) {
        if (!contains(key)) throw new NoSuchElementException("Key not in set");
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (key.length() == d) {
            x.endOfString = 0;
            N--;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.endOfString != -1) return x;
        for (char c = 0; c<R; c++) {
            if (x.next[c] != null) return x;
        }
        return null;
    }

    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("Null keys are disallowed");
        if (isEmpty()) return false;
        int M = key.length();
        Node x = root;
        for (int k = 0; k<M; k++) {
            char c = key.charAt(k);
            if (x.next[c] == null) return false;
            x = x.next[c];
            if (k == M-1 && x.endOfString != -1) return false;
        }
        return true;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        MyTrieSet set = new MyTrieSet();
        In in = new In(args[0]);
        while (!in.isEmpty()) set.add(in.readString());
        StdOut.println("size: " + set.size());
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("-".equals(s)) set.delete(StdIn.readString());
            else if (set.contains(s)) StdOut.println("yes");
            else StdOut.println("no");
            StdOut.println("size: " + set.size());
        }
    }
}
