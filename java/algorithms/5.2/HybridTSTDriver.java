public class HybridTSTDriver
{
    public static void main(String[] args) {
        java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<String, Integer>();
        HybridTST<Integer> tst = new HybridTST<Integer>();
        In in1 = new In(args[0]);
        In in2 = new In(args[1]);

        Stopwatch mapTime = new Stopwatch();
        while (!in1.isEmpty()) {
            String s = in1.readString();
            if (treeMap.containsKey(s)) treeMap.put(s, treeMap.get(s)+1);
            else treeMap.put(s, 1);
        }
        int size = treeMap.size();
        StdOut.println(size);
        while (!in2.isEmpty()) {
            String s = in2.readString();
            if (treeMap.containsKey(s)) {
                int t = treeMap.get(s);
            }
        }
        StdOut.println("Tree map took : " + mapTime.elapsedTime());

        in1 = new In(args[0]);
        in2 = new In(args[1]);
        Stopwatch trieTime = new Stopwatch();
        while (!in1.isEmpty()) {
            String s = in1.readString();
            if (tst.contains(s)) tst.put(s, tst.get(s)+1);
            else tst.put(s, 1);
        }
        size = tst.size();
        StdOut.println(size);
        while (!in2.isEmpty()) {
            String s = in2.readString();
            if (tst.contains(s)) {
                int t = tst.get(s);
            }
        }
        StdOut.println("Hybrid TST took : " + trieTime.elapsedTime());
    }
}
