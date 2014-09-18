public class DocSim
{
    public static double dist(String f1, String f2, int k) {
        TST<Double> tst1 = buildTST(f1, k);
        TST<Double> tst2 = buildTST(f2, k);
        double dist = 0.0;
        for (String s : tst1.keys()) {
            if (tst1.contains(s)) {
                Double p = tst1.get(s);
                Double q = tst2.get(s);
                if (p == null || q == null) continue;
                dist += ((p - q)*(p - q));
            }
        }
        return Math.sqrt(dist);
    }

    private static TST<Double> buildTST(String fileName, int k) {
        String text = (new In(fileName)).readAll();
        int N = text.length();
        int cnt = N/k; //Number of k-units in text
        double freq = 1.0/cnt;
        TST<Double> tst = new TST<Double>();
        for (int i = 0; i<N-k; i++) {
            String s = text.substring(i, i+k);
            if (tst.contains(s)) tst.put(s, tst.get(s) + freq);
            else tst.put(s, freq);
        }
        return tst;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String f1 = args[1];
        String f2 = args[2];
        double dist = dist(f1, f2, k);
        StdOut.println(dist);
    }
}
