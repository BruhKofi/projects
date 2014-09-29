public class MyMergeSorter
{
    private static final int CUTOFF = 7;
    
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void mergeSort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        mergeSort(a, aux, 0, N-1);
    }


    private static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo)/2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
    
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k<=hi; k++) aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k<=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void buMergeSort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz<N; sz *= 2) {
            for (int lo = 0; lo<N-sz; lo = lo + 2*sz) {
                int b = lo;
                int m = lo+sz-1;
                int hi = Math.min(lo+2*sz-1, N-1);
                merge(a, aux, b, m, hi);
            }
        }
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i<=hi; i++) {
            for (int j = i; j>lo && less(a[j], a[j-1]); j--) exch(a, j, j-1);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
