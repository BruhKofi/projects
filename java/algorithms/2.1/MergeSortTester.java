public class MergeSortTester
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = rand(N);
        topDown(a);
        assert(isSorted(a));
        a = rand(N);
        bottomUp(a);
        assert(isSorted(a));
    }

    private static Double[] rand(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }

    private static boolean isSorted(Double[] a) {
        for (int i = 1; i<a.length; i++) {
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }
    
    public static void merge(Double[] a, Double[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++) aux[k] = a[k];
        for (int k = lo; k<=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void mergeFaster(Double[] a, Double[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = hi;
        int t = 0;
        for (int k = lo; k<=hi; k++) {
            if (k <= mid) aux[k] = a[k];
            else aux[k] = a[hi- t++];
        }
        for (int k = lo; k<=hi; k++) {
            if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j--];
        }
    }

    public static void topDown(Double[] a) {
        Double[] aux = new Double[a.length];
        int lo = 0;
        int hi = a.length - 1;
        topDown(a, aux, lo, hi);
    }

    private static void topDown(Double[] a, Double[] aux, int lo, int hi) {
        if (hi - lo < 16) {
            insertionSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo)/2;
        topDown(a, aux, lo, mid);
        topDown(a, aux, mid+1, hi);
        if (a[mid] < a[mid+1]) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void bottomUp(Double[] a) {
        int N = a.length;
        Double[] aux = new Double[N];
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N-sz; lo += 2*sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(N-1, lo + sz + sz - 1));
            }
        }
    }

    private static void insertionSort(Double[] a, int lo, int hi) {
        for (int i = lo+1; i<=hi; i++) {
            for (int j = i; j>lo && a[j-1] > a[j]; j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static void exch(Double[] a, int i, int j) {
        Double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
