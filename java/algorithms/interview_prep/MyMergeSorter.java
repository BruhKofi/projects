public class MyMergeSorter
{
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void mergeSort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        mergeSort(a, aux, 0, N-1);
    }


    private static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        for (int k = lo; k<=hi; k++) {
            if (less(a, i, j))
