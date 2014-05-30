public class MyHeapSort
{
    private static int cnt = 0;
    public static void sort(Comparable[] a) {
        int N = a.length-1;
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable[] a, int i, int j) {
        cnt++;
        return a[i].compareTo(a[j]) < 0;
    }

    private static void swim(Comparable[] a, int k) {
        while (k > 1 && less(a, k/2, k)) {
            exch(a, k, k/2);
            k /= 2;
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(a, j, j+1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 2; i<a.length; i++) {
            if (less(a, i, i-1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        cnt = 0;
        sort(a);
        StdOut.println(cnt);
        assert(isSorted(a));
    }
}
