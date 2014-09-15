public class MyHybridSort
{
    private static final int M = 1000;
    private static String[] aux;
    private static int R = 256;
    
    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            quickSort(a, lo, hi, d);
            return;
        }
        int[] cnt = new int[R+2];
        for (int i = lo; i<=hi; i++) cnt[charAt(a[i], d)+2]++;
        for (int r = 0; r<R+1; r++) cnt[r+1] += cnt[r];
        for (int i = lo; i<=hi; i++) aux[cnt[charAt(a[i], d)+1]++] = a[i];
        for (int i = lo; i<=hi; i++) a[i] = aux[i-lo];
        for (int r = 0; r<R; r++) sort(a, lo+cnt[r], lo+cnt[r+1]-1, d+1);
    }

    private static void quickSort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) return;
        int v = charAt(a[lo], d);
        int lt = lo, gt = hi;
        int i = lo+1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }
        quickSort(a, lo, lt-1, d);
        if (v >= 0) quickSort(a, lt, gt, d+1);
        quickSort(a, gt+1, hi, d);
    }

    private static void exch(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAll().split("\\s+");
        Stopwatch sw = new Stopwatch();
        sort(a);
        StdOut.println(sw.elapsedTime());
    }
}
