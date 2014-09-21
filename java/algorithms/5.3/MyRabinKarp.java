public class MyRabinKarp
{
    private String pat;
    private long patHash;
    private int M;
    private long Q;
    private final int R = 256;
    private long RM;

    public MyRabinKarp(String pat) {
        this.pat = pat;
        this.M = pat.length();
        Q = 997;
        RM = 1;
        for (int i = 1; i<=M-1; i++) {
            RM = (R*RM) % Q;
        }
        patHash = hash(pat, M);
    }

    public boolean check(int i) {
        return true;
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int i = 0; i<M; i++) {
            h = (R*h + key.charAt(i)) % Q;
        }
        return h;
    }

    private int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash) return 0;
        for (int i = M; i<N; i++) {
            txtHash = (txtHash + Q - RM*txt.charAt(i-M)%Q)%Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q;
            if (patHash == txtHash) return i-M+1;
        }
        return N;
    }
}
