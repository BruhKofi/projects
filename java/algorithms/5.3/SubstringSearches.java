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
        int M = pat.length(), N = txt.length();
        final int R = 256;
        int[][] dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        int X;
        int j;
        int i;
        for (j = 1, X = 0; j<M; j++) {
            for (int c = 0; c<R; c++) dfa[c][j] = dfa[c][X];
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
        }
        for (i = 0, j = 0; i<N && j<M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i-M;
        return N;
    }

    public static int BM(String pat, String txt) {
        int N = txt.length(), M = pat.length();
        final int R = 256;
        int[] right = new int[R];
        for (int i = 0; i<R; i++) right[i] = -1;
        for (int j = 0; j<M; j++) right[pat.charAt(j)] = j;

        int skip = 0;
        for (int i = 0; i<=N-M; i+= skip) {
            skip = 0;
            for (int j = M-1; j>=0; j--) {
                if (txt.charAt(i+j) != pat.charAt(j)) {
                    skip = j - right[txt.charAt(j+i)];
                    if (skip < 0) skip = 1;
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return N;
    }
        

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        int i = KMP(pat, txt);
        StdOut.println(i);
        StdOut.println(txt.substring(i, i+pat.length()));
    }
}
