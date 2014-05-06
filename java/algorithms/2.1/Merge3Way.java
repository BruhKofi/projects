public class Merge3Way
{
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
            if(a[i-1] > a[i]) return false;
        }
        return true;
    }

    public static void sort(Double[] a) {
        Double[] aux = new Double[a.length];
        sort(a, aux, 0, a.length-1);
    }

    public static void sort(Double[] a, Double[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid1 = lo + (hi - lo)/3;
        int mid2 = lo + 2*(hi - lo)/3;
        sort(a, aux, lo, mid1);
        sort(a, aux, mid1+1, mid2);
        sort(a, aux, mid2+1, hi);
        merge(a, aux, lo, mid1, mid2, hi);
    }
    
    public static void merge(Double[] a, Double[] aux, int lo, int mid1, int mid2, int hi) {
        if (mid1 <= lo && hi <= mid2) return;

        int i = lo;
        int j = mid1+1;
        int l = mid2+1;
        for (int k = lo; k<= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k<=hi; k++) {
            if (i > mid1) {
                if (j > mid2) a[k] = aux[l++];
                else if (l > hi) a[k] = aux[j++];
                else if (aux[j] < aux[l]) a[k] = aux[j++];
                else a[k] = aux[l++];
            } else if (j > mid2) {
                if (i > mid1) a[k] = aux[l++];
                else if (l > hi) a[k] = aux[i++];
                else if (aux[i] < aux[l]) a[k] = aux[i++];
                else a[k] = aux[l++];
            } else if (l > hi) {
                if (i > mid1) a[k] = aux[j++];
                else if (j > mid2) a[k] = aux[i++];
                else if (aux[i] < aux[j]) a[k] = aux[i++];
                else a[k] = aux[j++];
            } else if (aux[i] < aux[j] && aux[i] < aux[l]) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i] && aux[j] < aux[l]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[l++];
            }
        }
    }
}
