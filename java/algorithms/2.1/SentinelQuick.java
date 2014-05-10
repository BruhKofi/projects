public class SentinelQuick
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        sort(a);
        assert(isSorted(a));
    }

    private static boolean isSorted(Double[] a) {
        for (int i = 1; i<a.length; i++) {
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }

    public static void sort(Double[] a) {
        StdRandom.shuffle(a);
        Double max = Double.MIN_VALUE;
        int j = 0;
        for (int i = 0; i<a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                j = i;
            }
        }
        exch(a, j, a.length-1);
        sort(a, 0, a.length-1);
    }

    private static void sort(Double[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Double[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        Double v = a[lo];
        while (true) {
            while (v > a[++i]);
            while (v < a[--j]);
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(Double[] a, int i, int j) {
        Double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
        
