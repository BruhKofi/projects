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
        Node x = root;
        int N = s.length();
        for (int i = 0; i<N; i++) {
            char c = s.charAt(i);
            if (x.next[c] == null) return;
            boolean delete = true;
            for (int r = 0; r<R; r++) {
                if (x.next[r] != null) delete = false;; // Don't return, still need to set value to null
            }
            if (delete) {
                Node t = x.next[c];
                x = null;
                x = t;
            }
        }
        if (x.val != null) x.val = null;
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
        
