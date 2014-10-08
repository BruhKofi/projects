public class Library
{
    private static final int DOUBLE_BOUND = 10000;
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        StdOut.println(passBet(T));
    }

    private static void print(double[] a) {
        for (int i = 0; i<a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    private static double[] makeDoubleArray(int N) {
        double[] a = new double[N];
        for (int i = 0; i<a.length; i++) a[i] = randomDouble(DOUBLE_BOUND);
        return a;
    }

    private static double randomDouble(int N) {
        return N*Math.random();
    }
    
    public static void normalize(double[] a) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        int N = a.length;
        for (int i = 0; i<N; i++) {
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
        }

        for (int i = 0; i<N; i++) {
            a[i] -= min;
            a[i] /= (max-min);
        }
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        int N = a.length;//rows a
        int M = a[0].length;//cols a
        if (M != b.length) throw new IndexOutOfBoundsException("Dimensions do not match");
        int P = b[0].length;//cols b

        double[][] c = new double[N][P];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<P; j++) {
                for (int k = 0; k<M; k++) {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }

    private static double[][] randMatrix(int N, int M) {
        double[][] a = new double[N][M];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                a[i][j] = StdRandom.uniform();
            }
        }
        return a;
    }

    private static void printMatrix(double[][] a) {
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[0].length; j++) {
                StdOut.print(a[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static int roll() {
        return 1 + StdRandom.uniform(6);
    }

    // T trials of a pass bet in craps
    // Return probability of winning
    public static double passBet(int T) {
        int wins = 0;
        for (int t = 0; t<T; t++) {
            int sum = roll() + roll();
            if (sum == 7 || sum == 11) wins++;
            else if (sum == 2 || sum == 3 || sum == 12) {}
            else {
                while (true) {
                    int newSum = roll() + roll();
                    if (newSum == sum) {
                        wins++;
                        break;
                    } else if (newSum == 7) break;
                }
            }
        }
        return wins/(double)T;
    }
}
