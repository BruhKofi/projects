public class SampleKMP
{
    private String pat;
    private final int[][] dfa;
    private final int R;

    public SampleKMP(String pat)
    {
        this.R = 256;
        this.pat = pat;
        int M = pat.length();
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j<M; j++) {
            for(int c = 0; c<R; c++) {
                dfa[c][j] = dfa[c][X];
                dfa[pat.charAt(j)][j] = j+1;
            }
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i<N && j<M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i-M;
        else return N;
    }

    public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        SampleKMP kmp = new SampleKMP(pat);
        int i = kmp.search(txt);
        StdOut.println(txt.substring(i, i+pat.length()));
    }
}
