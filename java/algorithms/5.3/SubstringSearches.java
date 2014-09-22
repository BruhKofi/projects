public class SubstringSearches
{
    public static int bruteForce(String pat, String txt) {
        int N = txt.length(), M = pat.length();
        int i, j = 0;
        for (i = 0; i<N-M; i++) {
            while (j < M && txt.charAt(i+j) == pat.charAt(j)) j++;
            if (j == M) return i;
            else j = 0;
        }
        return N;
    }

    public static int KMP(String pat, String txt) {
        return -1;
    }

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        int i = bruteForce(pat, txt);
        StdOut.println(i);
        StdOut.println(txt.substring(i, i+pat.length()));
    }
}
