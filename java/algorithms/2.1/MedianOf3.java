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
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Double[] a, int lo, int hi) {
        int p = sample(a, lo, hi);
        int i = lo+1;
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
        int[] sample = new int[3];
        for (int i = 0; i<3; i++) {
            sample[i] = StdRandom.uniform(hi + 1 - lo) + lo;
        }
        int min = min(sample, a);
        int max = max(sample, a);
        int mid = mid(sample, min, max);
        exch(a, lo, min);
        exch(a, hi, max);
        exch(a, lo+1, mid);
        return mid;
    }

    private static int min(int[] sample, Double[] a) {
        for (int i = 0; i<sample.length; i++) {
            for (int j = 0; j != i && j < sample.length; j++) {
                if (a[i] > a[j]) continue;
            }
            return i;
        }
        return -1;
    }

    private static int max(int[] sample, Double[] a) {
        for (int i = 0; i<sample.length; i++) {
            for (int j = 0; j != i && j < sample.length; j++) {
                if (a[i] < a[j]) continue;
            }
            return i;
        }
        return -1;
    }

    private static int mid(int[] sample, int i, int j) {
        for (int k = 0; k<sample.length; k++) {
            if (k != i && k != j) return k;
        }
        return -1;
    }
        
    private static void exch(Double[] a, int i, int j) {
        Double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
        
