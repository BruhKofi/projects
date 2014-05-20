public class HeapSortTester
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        double totalTime = 0.0;
        for (int t = 0; t<T; t++) {
            double[] a = new double[N+1];
            for (int i = 1; i<=N; i++) {
                a[i] = StdRandom.uniform();
            }
            totalTime += heapify(a);
            assert(isSorted(a));
        }
        StdOut.println("Average time to construct a heap from " + N + " random doubles is " + totalTime/(double)T);
    }

    private static double heapify(double[] a) {
        int N = a.length-1;
        Stopwatch sw = new Stopwatch();
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }
        double d = sw.elapsedTime();
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
        return d;
    }

    private static void sink(double[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && a[j] < a[j+1]) j++;
            if (a[k] > a[j]) break;
            exch(a, j, k);
            k = j;
        }
    }

    private static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean isSorted(double[] a) {
        for (int i = 2; i<a.length; i++) {
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }
}
        