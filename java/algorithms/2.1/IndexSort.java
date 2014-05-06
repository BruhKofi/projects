public class IndexSort
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        int[] perm = sort(a);
        for (int i = 0; i<N; i++) {
            exch(a, i, perm[i]);
        }
        assert(isSorted(a));
    }

    private static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean isSorted(double[] a) {
        for (int i = 1; i<a.length; i++) {
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }

    public static int[] sort(double[] a) {
        int N = a.length;
        double[] aux = new double[N];
        int[] p = new int[N];
        int[] paux = new int[N];
        for (int i = 0; i<N; i++) {
            p[i] = i;
        }
        sort(a, aux, p, paux, 0, N-1);
        return p;
    }

    private static void sort(double[] a, double[] aux, int[] p, int[] paux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        if (a[mid] < a[mid+1]) return;
        sort(a, aux, p, paux, lo, mid);
        sort(a, aux, p, paux, mid+1, hi);
        merge(a, aux, p, paux, lo, mid, hi);
    }

    private static void merge(double[] a, double[] aux, int[] p, int[] paux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++) {
            aux[k] = a[k];
            paux[k] = p[k];
        }
        for (int k = lo; k<=hi; k++) {
            if (i > mid) {
                a[k] = aux[j];
                p[k] = paux[j++];
            } else if (j > hi) {
                a[k] = aux[i];
                p[k] = paux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i];
                p[k] = paux[i++];
            } else {
                a[k] = aux[j];
                p[k] = paux[j++];
            }
        }
    }
}