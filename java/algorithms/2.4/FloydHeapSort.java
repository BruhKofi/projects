public class FloydHeapSort
{
    private static int cnt = 0;
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N+1];
        for (int i = 1; i<=N; i++) {
            a[i] = StdRandom.uniform();
        }
        cnt = 0;
        sort(a);
        StdOut.println(cnt);
        assert(isSorted(a));
    }
    
    public static void sort(Comparable[] a) {
        int N = a.length-1;
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sinkAndSwim(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int i, int j) {
        while(2*i <= j) {
            int k = 2*i;
            if (k < j && less(a, k, k+1)) k++;
            if (!less(a, i, k)) break;
            exch(a, i, k);
            i = k;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        cnt++;
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void sinkAndSwim(Comparable[] a, int i, int j) {
        while(2*i <= j) {
            int k = 2*i;
            if (k < j && less(a, k, k+1)) k++;
            exch(a, i, k);
            i = k;
        }
        swim(a, i);
    }

    private static void swim(Comparable[] a, int i) {
        while (i > 1 && less(a, i/2, i)) {
            exch(a, i/2, i);
            i /= 2;
        }
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 2; i<a.length; i++) {
            if (!less(a, i-1, i)) return false;
        }
        return true;
    }
}
            
