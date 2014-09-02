public class Seven
{
    private static boolean isPrime(int[] primes, int N) {
        int i = 0;
        while (primes[i] != 0) {
            if (N%primes[i++] == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] primes = new int[10001];
        primes[0] = 2;
        int i = 1;
        int N = 2;
        while (i < primes.length) {
            if (isPrime(primes, N)) {
                primes[i++] = N;
            }
            N++;
        }
        StdOut.println(primes[primes.length-1]);
    }
}