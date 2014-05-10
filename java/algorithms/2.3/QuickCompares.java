public class QuickCompares
{
    static int cnt = 0;
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        for (int t = 0; t<T; t++) {
            double[] a = new double[N];
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform();
            }
            sort(a);
        }
        StdOut.println("Quick sort required an average of " + (double)cnt/T + " compares to sort an array of length " + N + " over " + T + " trials");
    }

    private static void sort(double[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(double[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(double[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        double v = a[lo];
        while (true) {
            while (v < a[++i]) {
                cnt++;
                if (i == hi) break;
            }
            while (v > a[--j]) {
                cnt++;
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
