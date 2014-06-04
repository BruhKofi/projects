public class QuickSortTester
{
    public static void quick(int[] a) {
        StdRandom.shuffle(a);
        quick(a, 0, a.length-1);
    }

    public static void quick3Way(int[] a) {
        StdRandom.shuffle(a);
        quick3Way(a, 0, a.length-1);
    }

    private static void quick(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quick(a, lo, j-1);
        quick(a, j+1, hi);
    }

    private static void quick3Way(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        int v = a[lo];
        while (i <= gt) {
            if (a[i] < v) exch(a, lt++, i++);
            else if (a[i] > v) exch(a, i, gt--);
            else i++;
        }
        quick3Way(a, lo, lt-1);
        quick3Way(a, gt+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) if (i == hi) break;
            while (a[--j] > v) if (j == lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i<a.length; i++) {
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        int M = Integer.parseInt(args[2]);
        int[] a;
        double quickTime = 0.0;
        double quick3Time = 0.0;
        for (int t = 0; t<T; t++) {
            a = new int[N];
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform(M);
            }
            Stopwatch sw = new Stopwatch();
            quick(a);
            quickTime += sw.elapsedTime();
            assert(isSorted(a));
            a = new int[N];
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform(M);
            }
            sw = new Stopwatch();
            quick3Way(a);
            quick3Time += sw.elapsedTime();
            assert(isSorted(a));
        }
        StdOut.printf("Average time for quicksort to sort an array of %d integer is %5.5f\n", N, quickTime/T);
        StdOut.printf("Average time for 3-way quicksort to sort an array of %d integer is %5.5f\n", N, quick3Time/T);
    }
}