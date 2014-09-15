public class ReviewTrie<Value>
{
    private static final int R = 256;
    private Node root = new Node();

    private static class Node
    {
        private Node[] next = new Node[R];
        private Object val;
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (key.length() == d) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        else return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (key.length() == d) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (key.length() == d) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.val != null) return x;
        for (char c = 0; c<R; c++) {
            if (x.next[c] != null) return x;
        }
        return null;
    }

    public String longestPrefixOf(String pre) {
        int length = search(root, pre, 0, 0);
        return pre.substring(0, length);
    }

    private int search(Node x, String pre, int length, int d) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (pre.length() == d) return length;
        char c = pre.charAt(d);
        return search(x.next[c], pre, length, d+1);
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<String>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String s, Queue<String> q) {
        if (x == null) return;
        if (x.val != null) q.enqueue(s);
        for (char c = 0; c<R; c++) {
            collect(x.next[c], s+c , q);
        }
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<String>();
        collect(root, "", pat, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) q.enqueue(pre);
        if (d == pat.length()) return;
        char next = pat.charAt(d);
        for (char c = 0; c<R; c++) {
            if (c == next || c == '.') {
                collect(x.next[c], pre+c, pat, q);
            }
        }
    }
}
