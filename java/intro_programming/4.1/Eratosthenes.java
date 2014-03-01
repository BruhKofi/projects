public class Eratosthenes
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        byte[] isPrime = new byte[N+1];
        for (int i = 2; i<=N; i++) {
            for (int j = 0; j<8; j++) {
                isPrime[i] ^= 1 << j;
                StdOut.println(isPrime[i] ^= 1 << j);
            }
        }

        for (int i = 2; i <= N/i; i++) {
            for (int j = 0; j<8; j++) {
                if ((isPrime[i] & (1 << j)) == 0) {
                    for (int k = i; k <= N/i; k++) {
                        for (int l = j; l<8; l++) {
                            isPrime[i*j + l] ^= 1 << l;
                        }
                    }
                }
            }
        }
        int primes = 0;
        for (int i = 2; i<=N; i++) {
            for (int j = 0; j<8; j++) {
                if ((isPrime[i] & (1 << j)) == 0) primes++;
            }
        }
        StdOut.println(primes);
    }
}
