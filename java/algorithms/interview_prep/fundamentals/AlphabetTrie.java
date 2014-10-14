public class AlphabetTrie<Value>
{
    private static int R = 256;
    private final Alphabet alpha;
    private Node root;

    private static class Node
    {
        private Object val;
        private Node[] next = new Node[R];
    }

    public AlphabetTrie(Alphabet alpha) {
        this.R = alpha.R();
        this.alpha = alpha;
        root = new Node();
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value)x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        int index = alpha.toIndex(key.charAt(d));
        return get(x.next[index], key, d+1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        int index = alpha.toIndex(key.charAt(d));
        x.next[index] = put(x.next[index], key, val, d+1);
        return x;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public static void main(String[] args) {
        AlphabetTrie<Integer> trie = new AlphabetTrie<Integer>(new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        trie.put("HELLO", 1);
        assert(trie.contains("HELLO"));
        trie.put("WORLD", 2);
        StdOut.println(trie.get("WORLD"));
    }
}
