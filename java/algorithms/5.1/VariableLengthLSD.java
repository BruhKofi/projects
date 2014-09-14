public class VariableLengthLSD
{
    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        return -1;
    }
    
    public static void sort(String[] a) {
        int N = a.length;
        int W = Integer.MIN_VALUE;
        for (int i = 0; i<N; i++) if (a[i].length() > W) W = a[i].length();
        int R = 256;
        String[] aux = new String[N];

        for (int w = W; w >= 0; w--) {
            int[] cnt = new int[R+2];

            for (int i = 0; i<N; i++) cnt[charAt(a[i], w)+2]++;

            for (int r = 0; r<R+1; r++) cnt[r+1] += cnt[r];

            for (int i = 0; i<N; i++) aux[cnt[charAt(a[i], w)+1]++] = a[i];

            for (int i = 0; i<N; i++) a[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAll().split("\\s+");
        sort(a);
        for (String s : a) StdOut.println(s);
    }
}
