public class BitTest
{
    public static void main(String[] args) {
        for (int i = 0; i<64; i++) {
            long N = 1L << i;
            StdOut.println(N);
        }
    }
}