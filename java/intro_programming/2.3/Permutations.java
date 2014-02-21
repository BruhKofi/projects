public class Permutations
{
    public static void permutations(String s, int k) {
        permutations("", s, k);
    }

    public static void permutations(String prefix, String s, int k) {
        int N = s.length();
        if (N == 0) {
            StdOut.println(prefix);
            return;
        }
        for (int i = 0; i<N; i++) {
            String t = s.substring(0, i) + s.substring(i+1, N);
            for (int j = 0; j<N-k; j++) {
                String r = t.substring(j, j+k);
                permutations(prefix + s.charAt(i), r, k-1);
            }
        }
    }

    public static void main(String[] args) {
        final int a = 97;
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        String s = "";
        for (int i = 0; i<N; i++) {
            s += (char)(a+i);
        }
        permutations(s, k);
    }
}
