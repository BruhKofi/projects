public class MedianOf3
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
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }

    public static void sort(Double[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Double[] a, int lo, int hi) {
        if (hi - lo <= 3) {
            insertionSort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static void insertionSort(Double[] a, int lo, int hi) {
        StdOut.println(lo + " " + hi);
        for (int i = lo+1; i<=hi; i++) {
            for (int j = i; j > lo && a[j-1] > a[j]; j--) {
                StdOut.println(j);
                exch(a, j-1, j);
            }
        }
    }

    private static int partition(Double[] a, int lo, int hi) {
        int p = sample(a, lo, hi);
        StdOut.println(a[lo] + " " + a[p] + " " + a[hi]);
        int i = lo;
        int j = hi;
        Double v = a[p];
        while (true) {
            while (v > a[++i]);
            while (v < a[--j]);
            if (j <= i) break;
            exch(a, i, j);
        }
        exch(a, p, j);
        return j;
    }

    private static int sample(Double[] a, int lo, int hi) {
        StdOut.println(lo + " " + hi);
        int i = StdRandom.uniform(hi+1-lo) + lo;
        int j = 0;
        int k = 0;
        do {
            j = StdRandom.uniform(hi+1-lo) + lo;
        } while(j == i);
        do {
            k = StdRandom.uniform(hi+1-lo) + lo;
        } while(k == i || k == j);
        StdOut.println(i + " " + j + " " + k);
        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
        //i min
        if (a[i] <= a[j] && a[i] <= a[k]) {
            exch(a, i, lo);
            //j max
            if (a[j] >= a[k]) {
                exch(a, j, hi);
                return k;
            } else {//k max
                exch(a, k, hi);
                return j;
            }
        } else if (a[j] <= a[i] && a[j] <= a[k]) {//j min
            exch(a, j, lo);
            if (a[i] >= a[k]) {//i max
                exch(a, i, hi);
                return k;
            } else {
                exch(a, k, hi);//k max
                return i;
            }
        } else {//k min
            exch(a, k, lo);
            if (a[i] >= a[j]) {//i max
                exch(a, i, hi);
                return j;
            } else {
                exch(a, j, hi);//j max
                return i;
            }
        }
    }

    private static void exch(Double[] a, int i, int j) {
        Double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
        
