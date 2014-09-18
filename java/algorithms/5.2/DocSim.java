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
        int N = args.length-1;
        String[] files = new String[N];
        for (int i = 1; i<args.length; i++) files[i-1] = args[i];
        double[][] matrix = new double[N][N];
        for (int i = 0; i<N; i++) {
            for (int j = i; j<N; j++) {
                matrix[i][j] = dist(files[i], files[j], k);
                matrix[j][i] = matrix[i][j];
            }
        }
        StdOut.print("\t\t");
        for (String fileName : files) StdOut.print(fileName + "\t");
        StdOut.println();
        for (int i = 0; i<N; i++) {
            StdOut.print(files[i] + "\t");
            for (int j = 0; j<N; j++) {
                StdOut.printf("%.4f\t\t", matrix[i][j]);
            }
            StdOut.println();
        }
    }
}
