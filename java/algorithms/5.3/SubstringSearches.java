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

    public static int RabinKarp(String pat, String txt) {
        int N = txt.length(), M = pat.length();
        long Q = 997;//longRandomPrime();
        int R = 256;
        long patHash = hash(pat, M, R, Q);
        long RM = 1;
        for (int i = 1; i<=M-1; i++) RM = (R*RM)%Q;
        long txtHash = hash(txt, M, R, Q);
        if (patHash == txtHash) return 0;
        for (int i = M; i<N; i++) {
            txtHash = (txtHash + Q - (RM*txt.charAt(i-M)) % Q) % Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q;
            if (patHash == txtHash) return i-M+1;
        }
        return N;
    }

    private static long longRandomPrime() {
        long L = Long.MAX_VALUE;
        long r = 0;
        do {
            double d = Math.random();
            r = (long)(d*L)+1;
        } while (r % 2 == 0 || !isPrime(r));
        return r;
    }

    private static boolean isPrime(long l) {
        if (l < 2) return false;
        if (l == 2) return true;
        if (l == 3) return true;
        for (long i = 2; i*i<=l; i++) {
            if (l % i == 0) return false;
        }
        return true;
    }
    

    private static long hash(String key, int M, int R, long Q) {
        long h = 0;
        for (int i = 0; i<M; i++) {
            h = (h*R + key.charAt(i)) % Q;
        }
        return h;
    }
        

    public static void main(String[] args) {
        StdOut.println(longRandomPrime());
    }
}
