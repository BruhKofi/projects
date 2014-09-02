public class Three
{
    public static void main(String args[]) {
        long N = Long.parseLong(args[0]);
        int k = largestPrimeFactor(N);
        StdOut.println("The largest prime factor of " + N + " is " + k);
    }

    private static int largestPrimeFactor(long N) {
        long M = N;
        int i = 2;
        while (i <= M) {
            while (M%i == 0) M/=i;
            i++;
        }
        return i-1;
    }
}