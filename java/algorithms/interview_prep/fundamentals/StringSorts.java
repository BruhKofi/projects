/*
  Compare various String sorts
*/

public class StringSorts
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int size = 26;
    private static final char OFFSET = 'A';
    private static final int CUTOFF = 7;
    private static final int HYBRID_CUTOFF = 150;
    private static final boolean HYBRID = true;

    private static void printArray(String[] a) {
        for (int i = 0; i<a.length; i++) StdOut.println(a[i]);
    }
    
    private static String randString(int W) {
        StringBuilder sb = new StringBuilder(W);
        for (int i = 0; i<W; i++) sb.append(alphabet.charAt(StdRandom.uniform(size)));
        return sb.toString();
    }

    // N String of length W
    private static String[] randStringArray(int N, int W) {
        String[] a = new String[N];
        for (int i = 0; i<N; i++) a[i] = randString(W);
        return a;
    }

    private static boolean lsdWellFormed(String[] a) {
        int N = a[0].length();
        for (int i = 0; i<a.length; i++) {
            if (N != a[i].length()) return false;
        }
        return true;
    }

    private static boolean isSorted(String[] a) {
        for (int i = 1; i<a.length; i++) if (a[i-1].compareTo(a[i]) > 0) return false;
        return true;
    }

    private static int charAt(String s, int k) {
        if (k >= s.length()) return -1;
        return s.charAt(k) - OFFSET;
    }

    // LSD String sort
    public static void lsdSort(String[] a) {
        assert(lsdWellFormed(a));
        int W = a[0].length();
        int N = a.length;
        String[] aux = new String[N];
        for (int w = W-1; w >= 0; w--) {
            indexSort(a, aux, w);
        }
        assert(isSorted(a));
    }

    private static void indexSort(String[] a, String[] aux, int w) {
        assert(a.length == aux.length);
        int N = a.length;
        int[] cnt = new int[size+1];
        for (int i = 0; i<N; i++) cnt[a[i].charAt(w)-OFFSET+1]++;
        for (int i = 0; i<size; i++) cnt[i+1] += cnt[i];
        for (int i = 0; i<N; i++) {
            aux[cnt[a[i].charAt(w)-OFFSET]++] = a[i];
        }
        for (int i = 0; i<N; i++) a[i] = aux[i];
    }

    public static void insertionSort(String[] a) {
        insertionSort(a, 0, a.length-1, 0);
        assert(isSorted(a));
    }

    private static void insertionSort(String[] a, int lo, int hi) {
        for (int i = lo; i<=hi; i++) {
            for (int j = i; j>lo && a[j-1].compareTo(a[j]) > 0; j--) {
                exch(a, j-1, j);
            }
        }
    }

    private static void insertionSort(String[] a, int lo, int hi, int w) {
        for (int i = lo; i<=hi; i++) {
            for (int j = i; j>lo && less(a[j], a[j-1], w); j--) exch(a, j-1, j);
        }
    }

    // Compare Strings, only from char w onwards
    private static boolean less(String a, String b, int w) {
        for (int i = w; i<Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) < b.charAt(i)) return true;
            else if (a.charAt(i) > b.charAt(i)) return false;
        }
        return a.length() < b.length();
    }

    private static void exch(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Handles variable length String keys, but sacrifices efficiency due to recursive stack
    // Requires initializing a cnt array on each recursive call
    // This is prohibitively expensive for large alphabets -- must to cutoff to insertion sort
    public static void msdSort(String[] a) {
        String[] aux = new String[a.length];
        msdSort(a, aux, 0, a.length-1, 0, !HYBRID);
        assert(isSorted(a));
    }

    private static void msdSort(String[] a, String[] aux, int lo, int hi, int w, boolean hybrid) {
        if (hybrid) {
            if (hi <= lo + HYBRID_CUTOFF) {
                quickSort(a, lo, hi, w);
                return;
            }
        }
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi, w);
            return;
        }
        int N = a.length;
        assert(a.length == aux.length);
        int[] cnt = new int[size+2];
        for (int i = lo; i<=hi; i++) cnt[charAt(a[i], w)+2]++;
        for (int i = 0; i<size+1; i++) cnt[i+1] += cnt[i];
        for (int i = lo; i<=hi; i++) aux[cnt[charAt(a[i], w)+1]++] = a[i];
        for (int i = lo; i<=hi; i++) a[i] = aux[i-lo];
        
        for (int i = 0; i<size; i++) msdSort(a, aux, lo+cnt[i], lo+cnt[i+1]-1, w+1, hybrid);
    }

    public static void quickSort(String[] a) {
        quickSort(a, 0, a.length-1, 0);//May want to shuffle array first
        assert(isSorted(a));
    }

    private static void quickSort(String[] a, int lo, int hi, int w) {
        if (hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi, w);
            return;
        }
        int lt = lo, gt = hi;
        int v = charAt(a[lo], w); // -1 if w exceeds String length-1
        int i = lo+1;
        // Partition on current char of key (left -> right)
        while (i <= gt) {
            int t = charAt(a[i], w);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }

        quickSort(a, lo, lt-1, w);
        if (v >= 0) quickSort(a, lt, gt, w+1);
        quickSort(a, gt+1, hi, w);
    }

    public static void hybridSort(String[] a) {
        int N = a.length;
        String[] aux = new String[N];
        msdSort(a, aux, 0, N-1, 0, HYBRID);
        assert(isSorted(a));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int W = Integer.parseInt(args[1]);
        String[] a = randStringArray(N, W);
        Stopwatch sw = new Stopwatch();
        // insertionSort(a);
        // StdOut.printf("insertion sort: time to sort %d strings, each of length %d: %7.5f\n", N, W, sw.elapsedTime());
        a = randStringArray(N, W);
        sw = new Stopwatch();
        lsdSort(a);
        StdOut.printf("LSD sort: time to sort %d strings, each of length %d: %7.5f\n", N, W, sw.elapsedTime());
        a = randStringArray(N, W);
        sw = new Stopwatch();
        msdSort(a);
        StdOut.printf("MSD sort: time to sort %d strings, each of length %d: %7.5f\n", N, W, sw.elapsedTime());
        a = randStringArray(N, W);
        sw = new Stopwatch();
        quickSort(a);
        StdOut.printf("Quick sort: time to sort %d strings, each of length %d: %7.5f\n", N, W, sw.elapsedTime());
        a = randStringArray(N, W);
        sw = new Stopwatch();
        hybridSort(a);
        StdOut.printf("Hybrid sort: time to sort %d strings, each of length %d: %7.5f\n", N, W, sw.elapsedTime());
        a = randStringArray(N, W);
        sw = new Stopwatch();
        java.util.Arrays.sort(a);
        StdOut.printf("Java Arrays system sort: time to sort %d strings, each of length %d: %7.5f\n", N, W, sw.elapsedTime());
    }
}
