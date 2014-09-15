public class MyMSD
{
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String randLenString(int W) {
        int K = StdRandom.uniform(W);
        StringBuilder sb = new StringBuilder(K);
        for (int i = 0; i<K; i++) sb.append(alphabet.charAt(StdRandom.uniform(26)));
        return new String(sb);
    }
    
    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) return;

        int[] count = new int[R+2];

        //Frequency count
        for (int i = lo; i<=hi; i++) count[charAt(a[i], d) + 2]++;

        //Index find
        for (int r = 0; r<R+1; r++) count[r+1] += count[r];

        //Sort to aux
        for (int i = lo; i<=hi; i++) aux[count[charAt(a[i], d) + 1]++] = a[i];

        //Copy back
        for (int i = lo; i<=hi; i++) a[i] = aux[i-lo];

        //Recurse
        for (int r = 0; r<R; r++) sort(a, lo + count[r], lo + count[r+1] - 1, d+1);
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAll().split("\\s+");
        Stopwatch sw = new Stopwatch();
        sort(a);
        StdOut.println(sw.elapsedTime());
    }
}
