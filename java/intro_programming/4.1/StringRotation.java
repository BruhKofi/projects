public class StringRotation
{
    public static String rotate(String s, int index) {
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

    public static void rotate(char[] x, int index) {
        int N = x.length;
        int k = index % N;
        if (k == 0) return;
        reverse(x, 0, N);
        reverse(x, 0, N-k);
        reverse(x, N-k, N);
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
        String s = args[0];
        for (int i = 0; i<s.length(); i++) {
            char[] x = s.toCharArray();
            rotate(x, i);
            StdOut.println("character array\t\t" + new String(x));
            StdOut.println("string\t\t\t" + rotate(s, i));
        }
    }
}
