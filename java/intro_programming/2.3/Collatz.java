public class Collatz
{
    public static int collatz(int n, int calls) {
        calls++;
        if (n == 1) return calls;
        if (n%2 == 0) return collatz(n/2, calls);
        else return collatz(3*n + 1, calls);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int max = Integer.MIN_VALUE;
        int n = 0;
        for (int i = 1; i<=N; i++) {
            int m = collatz(i, 0);
            if (m > max) {
                max = m;
                n = i;
            }
        }
        StdOut.printf("%d required %d recursive calls\n", n, max);
    }
}
