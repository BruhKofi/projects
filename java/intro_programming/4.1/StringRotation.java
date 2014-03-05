public class StringRotation
{
    public static String rotateString(String s, int index) {
        int N = s.length();
        int k = index % N;
        if (k == 0) return s;
        String r = reverse(s);
        return reverse(r.substring(0, N-k)) + reverse(r.substring(N-k, N));
    }

    private static String reverse(String s) {
        int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i<N; i++) {
            a[i] = s.charAt(N - i - 1);
        }
        return new String(a);
    }

    public static String rotateChar(String s, int index) {
        char[] x = s.toCharArray();
        int N = x.length;
        int k = index % N;
        if (k == 0) return s;
        reverse(x, 0, N);
        reverse(x, 0, N-k);
        reverse(x, N-k, N);
        return new String(x);
    }

    private static void reverse(char[] x, int lo, int hi) {
        for (int i = lo; i <  lo + (hi - lo)/2; i++) {
            swap(x, i, hi + lo - i - 1);
        }
    }

    private static void swap(char[] x, int i, int j) {
        char t = x[i];
        x[i] = x[j];
        x[j] = t;
    }

    public static void main(String[] args) {
        String text = StdIn.readAll();
        int N = text.length();
        StdOut.println(N);
        Stopwatch sw = new Stopwatch();
        rotateString(text, 800);
        StdOut.println("String only: " + sw.elapsedTime() + " seconds");
        Stopwatch sw2 = new Stopwatch();
        rotateChar(text, 800);
        StdOut.println("Character array : " + sw2.elapsedTime() + " seconds");
    }
}
