public class Combinations
{
    public static void combinations(String s) {
        combinations("", s);
    }

    public static void combinations(String prefix, String s) {
        StdOut.println(prefix);
        for (int i = 0; i<s.length(); i++) {
            combinations(prefix + s.charAt(i), s.substring(i+1));
        }
    }

    public static void main(String[] args) {
        final int a = 97;
        int N = Integer.parseInt(args[0]);
        String s = "";
        for (int i = 0; i<N; i++) {
            s += (char)(a+i);
        }
        combinations(s);
    }
}
