public class TrieTester
{
    //Compare performance of java.util.TreeMap with Sedgewick's implementation of a Trie symbol table
    //Build frequency counter for strings in input file
    //Then check if strings in a second file occur in the first
    public static void main(String[] args) {
        java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<String, Integer>();
        TrieST<Integer> trie = new TrieST<Integer>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String s = in.readString();
            if (treeMap.containsKey(s)) treeMap.put(s, treeMap.get(s)+1);
            else treeMap.put(s, 1);
        }
        for (String s : treeMap.keySet()) {
            trie.put(s, treeMap.get(s));
        }

        in = new In(args[1]);
        Stopwatch sw = new Stopwatch();
        while (!in.isEmpty()) {
            String s = in.readString();
            if (treeMap.containsKey(s)) {
                int t = treeMap.get(s);
            }
        }
        StdOut.println("Tree map took : " + sw.elapsedTime());

        in = new In(args[1]);
        sw = new Stopwatch();
        while (!in.isEmpty()) {
            String s = in.readString();
            if (trie.contains(s)) {
                int t = trie.get(s);
            }
        }
        StdOut.println("Trie took : " + sw.elapsedTime());
    }
}
