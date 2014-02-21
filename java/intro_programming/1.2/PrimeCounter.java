public class PrimeCounter
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int primes = 0;
        for (int i = 2; i<=N; i++) {
            if (isPrime(i)) primes++;
        }
        System.out.println(primes);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 2; i*i<=n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}
