public class ErdosRenyi
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int cnt = 0;
        for (int i = 0; i<T; i++) {
            cnt += count(N);
        }
        StdOut.println("The number of random pairs required to get a single component is " + (double)cnt/T);
    }

    public static int count(int N) {
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
}