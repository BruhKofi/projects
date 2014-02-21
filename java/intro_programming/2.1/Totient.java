public class Totient
{
    public static int totient(int N) {
        int count = 0;
        for (int i = 1; i<=N; i++) {
            if (coprime(i, N)) {
                count++;
            }
        }
        return count;
    }

    public static boolean coprime(int n, int m) {
        return gcd(n, m) == 1;
    }

    public static int gcd(int n, int m) {
        if (m == 1) {
            return 1;
        }
        int r = n%m;
        if (r == 0) {
            return m;
        } else {
            n = m;
            m = r;
            return gcd(n, m);
        }
    }

    public static void main(String[] args) {
        for (int i = 10; i<100; i++) {
            StdOut.println(i + " " + totient(i));
        }
    }
}
