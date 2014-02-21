public class McCarthy
{
    public static int mcCarthy(int n) {
        StdOut.println(n);
        if (n > 100) return n-10;
        return mcCarthy(mcCarthy(n+11));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(mcCarthy(N));
    }
}
