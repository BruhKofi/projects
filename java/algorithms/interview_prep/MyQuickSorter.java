public class MyQuickSorter
{
    private static final int CUTOFF = 7;
    
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i<=hi; i++) for (int j = i; j > lo && less(a[j], a[j-1]); j--) exch(a, j, j-1);
    }

    public static void quickSort(Comparable[] a) {
        StdRandom.shuffle(a);
        quickSort(a, 0, a.length-1);
    }

    private static void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo, j = hi+1;
        while (true) {
            while (less(a[++i], v)) if (i >= hi) break;
            while (less(v, a[--j])) if (j <= lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void quick3Way(Comparable[] a) {
        StdRandom.shuffle(a);
        quick3Way(a, 0, a.length-1);
    }

    private static void quick3Way(Comparable[] a, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }
        Comparable v = a[lo];
        int lt = lo, gt = hi, i = lo;
        while (i <= gt) {
            int cmp = v.compareTo(a[i]);
            if (cmp > 0) exch(a, lt++, i++);
            else if (cmp < 0) exch(a, i, gt--);
            else i++;
        }
        quick3Way(a, lo, lt-1);
        quick3Way(a, gt+1, hi);
    }

}
