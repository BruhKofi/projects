/*
  Compare various String sorts
*/

public class StringSorts
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int size = 26;
    private static final char OFFSET = 'A';

    private static String randString(int W) {
        StringBuilder sb = new StringBuilder(W);
        for (int i = 0; i<W; i++) sb.append(alphabet.charAt(StdRandom.uniform(size)));
        return sb.toString();
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int W = Integer.parseInt(args[1]);
        for (int i = 0; i<N; i++) {
            StdOut.println(randString(W));
        }
    }
}
