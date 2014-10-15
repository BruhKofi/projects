public class IterativeTrieST<Value>
{
    private static final int R = 256;
    private Node root = new Node();
    private int N;

    private static class Node
    {
        private Object val;
        private Node[] next = new Node[R];
    }

    public void put(String s, Value val) {
        Node x = root;
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (x.next[c] == null) x.next[c] = new Node();
            x = x.next[c];
        }
        if (x.val == null) N++;
        x.val = val;
    }

    public Value get(String s) {
        Node x = root;
        int N = s.length();
        for (int i = 0; i<N; i++) {
            char c = s.charAt(i);
            if (x.next[c] == null) return null;
            x = x.next[c];
        }
        return (Value)x.val;
    }

    public boolean contains(String s) {
        return get(s) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public void delete(String s) {
        root = delete(root, s, 0);
    }

    private Node delete(Node x, String s, int d) {
        if (x == null) return null;
        if (d == s.length()) x.val = null;
        else {
            char c = s.charAt(d);
            x.next[c] = delete(x.next[c], s, d+1);
        }

        if (x.val != null) return x;
        for (char c = 0; c<R; c++) if (x.next[c] != null) return x;
        return null;
    }

    public static void main(String[] args) {
        IterativeTrieST<Integer> st = new IterativeTrieST<Integer>();
        st.put("Hello", 1);
        st.put("World", 2);
        StdOut.println(st.get("Hello"));
        StdOut.println(st.get("World"));
        st.delete("Hello");
        StdOut.println(st.contains("Hello"));
    }
}
        
