public class ErdosRenyi
{
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int cnt = 0;
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i<T; i++) {
            cnt += countWeightedQuickUnion(128);
        }
        double prev = sw.elapsedTime();
        for (int N = 256; true; N*=2) {
            cnt = 0;
            sw = new Stopwatch();
            for (int i = 0; i<T; i++) {
                cnt += countWeightedQuickUnion(N);
            }
            double current = sw.elapsedTime();
            StdOut.printf("%d %5.1f %5.1f", N, (double)cnt/T, current/prev);
            StdOut.println();
            prev = current;
        }
    }

    public static int countWeightedQuickUnion(int N) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        int cnt = 0;
        while (uf.count() > 1) {
            int n = StdRandom.uniform(N);
            int m = StdRandom.uniform(N);
            cnt++;
            if (!uf.connected(n, m)) {
                uf.union(n, m);
            }
        }
        return cnt;
    }

    public static int countQuickFind(int N) {
        QuickFindUF uf = new QuickFindUF(N);
        int cnt = 0;
        while (uf.count() > 1) {
            int n = StdRandom.uniform(N);
            int m = StdRandom.uniform(N);
            cnt++;
            if (!uf.connected(n, m)) {
                uf.union(n, m);
            }
        }
        return cnt;
    }

    public static int countQuickUnion(int N) {
        QuickUnionUF uf = new QuickUnionUF(N);
        int cnt = 0;
        while (uf.count() > 1) {
            int n = StdRandom.uniform(N);
            int m = StdRandom.uniform(N);
            cnt++;
            if (!uf.connected(n, m)) {
                uf.union(n, m);
            }
        }
        return cnt;
    }
}
