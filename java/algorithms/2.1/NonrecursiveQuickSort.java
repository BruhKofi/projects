public class NonrecursiveQuickSort
{
    public static void sort(Double[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

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

    private static void sort(Double[] a, int lo, int hi) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(lo);
        s.push(hi);
        while (!s.isEmpty()) {
            hi = s.pop();
            lo = s.pop();
            if (hi <= lo) continue;
            int j = partition(a, lo, hi);
            if (j - lo > hi - j) {
                s.push(lo);
                s.push(j-1);
                s.push(j+1);
                s.push(hi);
            } else {
                s.push(j+1);
                s.push(hi);
                s.push(lo);
                s.push(j-1);
            }
        }
    }

    private static int partition(Double[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        Double v = a[lo];
        while (true) {
            while (v > a[++i]) if (i == hi) break;
            while (v < a[--j]) if (j == lo) break;
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
