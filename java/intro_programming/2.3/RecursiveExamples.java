public class RecursiveExamples
{
    public static long factorial(int N) {
        if (N == 1) return 1;
        return N*factorial(N-1);
    }

    public static double logFactorial(int N) {
        if (N == 1) return 0;
        return Math.log(N) + logFactorial(N-1);
    }

    public static void ex233(int n) {
        if (n <= 0) return;
        StdOut.print(n + " ");
        ex233(n-2);
        ex233(n-3);
        StdOut.print(n + " ");
    }

    public static int mystery(int a, int b) {
        if (b == 0) return 1;
        if (b%2 == 0) return mystery(a*a, b/2);
        return mystery(a*a, b/2) * a;
    }

    public static void ruler(int n, double x) {
        if (n == 0) return;
        StdDraw.setPenRadius(0.05);
        StdDraw.line(x, 0.0, x, n);
        ruler(n-1, x/2);
    }

    public static int recurrence(int N) {
        if (N == 1) return 1;
        return 2*recurrence(N/2) + N;
    }

    public static String toBinary(int N) {
        String s = "";
        if (N == 0) return s;
        int r = N%2;
        N/=2;
        return toBinary(N) + r;
    }
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(toBinary(N));
    }
}
