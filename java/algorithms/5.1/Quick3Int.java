public class Quick3Int
{
    private static int[] aux;
    private static final int R = 10;

    private static int[] makeArray(int N) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) a[i] = StdRandom.uniform(N);
        return a;
    }
    
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    private static int intAt(int k, int d) {
        char[] digits = String.valueOf(k).toCharArray();
        if (d < digits.length) return digits[d];
        return -1;
    }

    public static void sort(int[] a) {
        int N = a.length;
        aux = new int[N];
        sort(a, 0, N-1, 0);
    }

    private static void sort(int[] a, int lo, int hi, int d) {
        if (hi <= lo) return;
        
        int v = intAt(a[lo], d);
        int lt = lo, gt = hi;
        int i = lt+1;

        while (i <= gt) {
            int t = intAt(a[i], d);
            if (t < v) exch(a, i++, lt++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt-1, d);
        if (v >= 0) sort(a, lt, gt, d+1);
        sort(a, gt+1, hi, d);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = makeArray(N);
        sort(a);
        for (int i : a) StdOut.println(i);
    }
}
