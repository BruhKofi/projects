public class CommonSubstring
{
    public static String lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i<N; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(0, i);
            }
        }
        return s.substring(0, N);
    }

    public static String lcs(String s, String t) {
        int N = s.length();
        int M = t.length();
        String[] suffixes = new String[N+M];
        for (int i = 0; i<N; i++) {
            suffixes[i] = s.substring(i, N);
        }
        for (int i = 0; i<M; i++) {
            suffixes[N+i] = t.substring(i, M);
        }
        Merge.sort(suffixes);
        String lcs = "";
        for (int i = 0; i<N+M-1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            if (x.length() > lcs.length() && s.contains(x) && t.contains(x)) lcs = x;
        }
        return lcs;
    }

    public static void main(String[] args) {
        In a = new In(args[0]);
        In b = new In(args[1]);
        String s = a.readAll();
        String t = b.readAll();

        StdOut.println(lcs(s, t));
    }
}