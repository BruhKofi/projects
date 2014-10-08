public class Recursion
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        StdOut.println(gcd(N, T));
    }

    
    private static void factorialTimer(int N, int T) {
        Stopwatch sw = new Stopwatch();
        for (int t = 0; t<T; t++) {
            factorial(N);
        }
        StdOut.println("Recursive: " + sw.elapsedTime());
        sw = new Stopwatch();
        for (int t = 0; t<T; t++) {
            iterativeFactorial(N);
        }
        StdOut.println("Iterative: " + sw.elapsedTime());
    }
    
    public static long factorial(long N) {
        return N == 0 || N == 1 ? 1 : N*factorial(N-1);
    }

    public static long iterativeFactorial(int N) {
        long fac = 1;
        for (int i = 1; i<=N; i++) fac *= i;
        return fac;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
