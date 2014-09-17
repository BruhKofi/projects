public class BruteForceSubstringSearch
{
    public static int search(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();
        for (int i = 0; i<N-M; i++) {
            int j;
            for (j = 0; j<M; j++) {
                if (pat.charAt(j) != txt.charAt(i+j)) break;
            }
            if (j == M) return i;
        }
        return N;
    }

    public static int search2(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();
        int i, j;
        for (i = 0, j = 0; i<N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;
        return N;
    }

    public static void main(String[] args) {
        String txt = args[0];
        String pat = args[1];

        int s1 = search(pat, txt);
        int s2 = search(pat, txt);

        StdOut.println(txt.substring(s1, s1 + pat.length()));
        StdOut.println(txt.substring(s2, s2 + pat.length()));
    }
}
