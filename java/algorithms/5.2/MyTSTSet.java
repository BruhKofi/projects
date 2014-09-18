public class MyTSTSet
{
    private Node root;
    private int N;

    private class Node
    {
        private Node left, mid, right;
        private char c;
        private int flag;
    }

    public void add(String key) {
        root = add(root, key, 0);
    }

    private Node add(Node x, String key, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c) x.left = add(x.left, key, d);
        else if (c > x.c) x.right = add(x.right, key, d);
        else if (d < key.length()-1) x.mid = add(x.mid, key, d+1);
        else {
            if (x.flag == 0) N++;
            x.flag = -1;
        }
        return x;
    }

    public boolean contains(String key) {
        if (key == null) throw new NullPointerException("Null keys are disallowed");
        if (key.isEmpty()) throw new IllegalArgumentException("Key must be non-empty string");
        return contains(root, key, 0);
    }

    private boolean contains(Node x, String key, int d) {
        if (x == null) return false;
        char c = key.charAt(d);
        if (c < x.c) return contains(x.left, key, d);
        else if (c > x.c) return contains(x.right, key, d);
        else if (d < key.length()-1) return contains(x.mid, key, d+1);
        else if (d == key.length()-1 && x.flag == -1) return true;
        else return false;
    }

    public boolean containsPrefix(String key) {
        if (key == null) throw new NullPointerException("Null keys are disallowed");
        if (key.isEmpty()) throw new IllegalArgumentException("Key must be non-empty string");
        return containsPrefix(root, key, 0);
    }

    private boolean containsPrefix(Node x, String key, int d) {
        if (x == null) return false;
        char c = key.charAt(d);
        if (c < x.c) return containsPrefix(x.left, key, d);
        else if (c > x.c) return containsPrefix(x.right, key, d);
        else if (d < key.length()-1) return containsPrefix(x.mid, key, d+1);
        else if (d == key.length()-1) return true;
        else return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return N;
    }

    public Iterable<String> keys() {
        Queue<String> q = new Queue<String>();
        collect(root, "", q);
        return q;
    }

    private void collect(Node x, String s, Queue<String> q) {
        if (x == null) return;
        collect(x.left, s, q);
        if (x.flag == -1) q.enqueue(s + x.c);
        collect(x.mid, s + x.c, q);
        collect(x.right, s, q);
    }

    public static void main(String[] args) {
        MyTSTSet set = new MyTSTSet();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            set.add(in.readString());
        }
        StdOut.println(set.size());
        for (String s : set.keys()) StdOut.println(s);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            StdOut.println(set.contains(s));
            StdOut.println(set.containsPrefix(s));
        }
    }
}
    
