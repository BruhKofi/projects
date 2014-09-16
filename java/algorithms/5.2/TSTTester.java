public class TSTTester
{
    public static void main(String[] args) {
        java.util.TreeMap<String, Integer> treeMap = new java.util.TreeMap<String, Integer>();
        TST<Integer> tst = new TST<Integer>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String s = in.readString();
            if (treeMap.containsKey(s)) treeMap.put(s, treeMap.get(s)+1);
            else treeMap.put(s, 1);
        }

        for (String s : treeMap.keySet()) {
            tst.put(s, treeMap.get(s));
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
            if (tst.contains(s)) {
                int t = tst.get(s);
            }
        }
        StdOut.println("TST took : " + sw.elapsedTime());
    }
}
