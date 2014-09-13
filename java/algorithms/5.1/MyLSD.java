public class MyLSD
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String randString(int W) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<W; i++) sb.append(alphabet.charAt(StdRandom.uniform(26)));
        return new String(sb);
    }
    
    private static boolean isValidLSDInput(String[] a, int W) {
        for (int i = 0; i<a.length; i++) if (a[i].length() != W) return false;
        return true;
    }

    private static boolean isSorted(String[] a) {
        for (int i = 1; i<a.length; i++) if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean less(String v, String w) {
        for (int i = 0; i<Math.min(w.length(), v.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            else if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
        
        
    public static void sort(String[] a, int W) {
        assert(isValidLSDInput(a, W));
        
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W-1; d >= 0; d--) {
            int[] count = new int[R+1];

            //Frequency count
            for (int i = 0; i<N; i++) count[a[i].charAt(d)+1]++;

            //Index find
            for (int r = 0; r<R; r++) count[r+1] += count[r];

            //Sort
            for (int i = 0; i<N; i++) aux[count[a[i].charAt(d)]++] = a[i];

            //Copy
            for (int i = 0; i<N; i++) a[i] = aux[i];
        }

        assert(isSorted(a));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int W = Integer.parseInt(args[1]);
        String[] a = new String[N];
        for (int i = 0; i<N; i++) {
            a[i] = randString(W);
        }
        sort(a, W);
        for (String s : a) StdOut.println(s);
    }
}
