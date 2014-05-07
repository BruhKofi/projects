public class NaturalMergesort
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        sort(a);
        assert(MySortDoublingTest.isSorted(a));
        MySortDoublingTest.printArray(a);
    }

    public static void sort(Double[] a) {
        Double[] aux = new Double[a.length];
        int mid = 0;
        int hi = 0;
        while (true) {
            int i = 0;
            while (a[i] < a[i+1] && i < a.length-2) i++;
            mid = i;
            if (mid == a.length-1) break;
            if (mid == a.length-2) {
                merge(a, aux, 0, mid, a.length-1);
                return;
            }
            int j = mid+1;
            while (a[j] < a[j+1] && j < a.length-2) j++;
            hi = j;
            merge(a, aux, 0, mid, hi);
        }
    }

    private static void merge(Double[] a, Double[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        for (int k = lo; k<=hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k<=hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] < aux[j]) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}

        