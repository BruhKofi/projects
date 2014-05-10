public class TwoSort
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i<N; i++) {
            if (StdRandom.bernoulli()) a[i] = 0;
            else a[i] = 1;
        }
        sort(a);
        assert(isSorted(a));
    }

    private static void print(int[] a) {
        for (int i = 0; i<a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i<a.length; i++) {
            if (a[i-1] > a[i]) return false;
        }
        return true;
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int lo, int hi) {
        int i = lo-1;
        int j = hi+1;
        int val1 = a[lo];
        int val2 = val1;
        for (int k = 0; k<a.length; k++) {
            if (a[k] != val1) {
                val2 = a[k];
                break;
            }
        }
        int min = Math.min(val1, val2);
        int max = Math.max(val1, val2);
        while (true) {
            while (a[++i] == min) if (i == hi) break;
            while (a[--j] == max) if (j == lo) break;
            if (j <= i) break;
            exch(a, i, j);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
        
