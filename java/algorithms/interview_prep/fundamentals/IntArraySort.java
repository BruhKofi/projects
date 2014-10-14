/*
  3-Way String quicksort for keys that are arrays of int values
*/
public class IntArraySort
{
    private static int[][] makeIntArray(int N) {
        int[][] a = new int[N][];
        for (int i = 0; i<N; i++) {
            int R = StdRandom.uniform(N);
            a[i] = new int[R];
            for (int j = 0; j<R; j++) a[i][j] = StdRandom.uniform(R);
        }
        return a;
    }

    private static boolean isSorted(int[][] a) {
        int N = a.length;
        for (int i = 1; i<N; i++) if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean less(int[] a, int[] b) {
        for (int i = 0; i<Math.min(a.length, b.length); i++) {
            if (a[i] > b[i]) return false;
        }
        return a.length < b.length;
    }

    private static int intAt(int[] a, int d) {
        if (d < a.length) return a[d];
        return -1;// Assume ints are non-negative
    }

    public static void sort(int[][] a) {
        int N = a.length;
        sort(a, 0, N-1, 0);
    }

    private static void sort(int[][] a, int lo, int hi, int d) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int i = lo+1;
        int v = intAt(a[lo], d);
        while (i <= gt) {
            int t = intAt(a[i], d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
    }

    private static void exch(int[][] a, int i, int j) {
        int[] t = new int[a[i].length];
        for (int k = 0; k<a[i].length; k++) t[k] = a[i][k];
        a[i] = new int[a[j].length];
        for (int k = 0; k<a[i].length; k++) a[i][k] = a[j][k];
        a[j] = new int[t.length];
        for (int k = 0; k<t.length; k++) a[j][k] = t[k];
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[][] a = makeIntArray(N);
        sort(a);
        assert(isSorted(a));
    }
}
