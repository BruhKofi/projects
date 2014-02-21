public class RelativePrimes
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        boolean[][] coprime = new boolean[N][N];

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (isCoprime(i, j)) {
                    coprime[i][j] = true;
                }
            }
        }

        printBooleanArray(coprime);

    }

    private static boolean isCoprime(int i, int j) {
        return gcd(i, j) == 1;
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int t = b;
            b = a%b;
            a = t;
        }
        return a;
    }

    private static void printBooleanArray(boolean[][] a) {
        int N = a.length;
        System.out.print("\t");
        for (int i = 0; i<N; i++) {
            System.out.print(i +"\t");
        }
        System.out.println();
        for (int i = 0; i<N; i++) {
            System.out.print((i) + "\t");
            for (int j = 0; j<a[i].length; j++) {
                if (a[i][j]) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
