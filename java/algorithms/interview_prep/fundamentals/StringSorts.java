/*
  Compare various String sorts
*/

public class StringSorts
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int size = 26;
    private static final char OFFSET = 'A';

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

    public static void msdSort(String[] a) {
        String[] aux = new String[a.length];
        msdSort(a, aux, 0, a.length-1, 0);
        assert(isSorted(a));
    }

    private static void msdSort(String[] a, String[] aux, int lo, int hi, int w) {
        if (hi <= lo) return;
        int N = a.length;
        assert(a.length == aux.length);
        int[] cnt = new int[size+2];
        for (int i = lo; i<=hi; i++) cnt[charAt(a[i], w)+2]++;
        for (int i = 0; i<size+1; i++) cnt[i+1] += cnt[i];
        for (int i = lo; i<=hi; i++) aux[cnt[charAt(a[i], w)+1]++] = a[i];
        for (int i = lo; i<=hi; i++) a[i] = aux[i-lo];
        
        for (int i = 0; i<size; i++) msdSort(a, aux, lo+cnt[i], lo+cnt[i+1]-1, w+1);
    }
        

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int W = Integer.parseInt(args[1]);
        String[] a = randStringArray(N, W);
        Stopwatch sw = new Stopwatch();
        msdSort(a);
        StdOut.printf("MSD sort: time to sort %d strings, each of length %d: %7.5f\n", N, W, sw.elapsedTime());
        a = randStringArray(N, W);
        sw = new Stopwatch();
        lsdSort(a);
        StdOut.printf("LSD sort: time to sort %d strings, each of length %d: %7.5f\n", N, W, sw.elapsedTime());
    }
}
