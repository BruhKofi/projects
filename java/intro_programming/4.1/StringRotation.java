public class StringRotation
{
    public static String rotate(String s, int index) {
        int N = s.length();
        String r = reverse(s);
        return reverse(r.substring(0, N - index)) + reverse(r.substring(N-index, N));
    }

    private static String reverse(String s) {
        int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i<N; i++) {
            a[i] = s.charAt(N - i - 1);
        }
        return new String(a);
    }

    public static void main(String[] args) {
        String s = args[0];
        for (int i = 0; i<s.length(); i++) {
            StdOut.println(rotate(s, i));
        }
    }
}
