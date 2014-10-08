public class MatrixLib
{
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

    public static double dot(double[] a, double[] b) {
        if (a.lenght != b.length) throw new IllegalArgumentException("Dimensions do not match");
        double sum = 0.0;
        for (int i = 0; i<a.length; i++) {
            sum += a[i]*b[i];
        }
        return sum;
    }

    public static double[][] transpose(double[][] a) {
        int N = a.length;
        int M = a[0].length;
        double[][] b = new double[M][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }

    public static double[] multiply(double[][] a, double[] x) {
        if (a[0].length != x.length) throw new IllegalArgumentException("Dimensions do not match");
        double[] b = new double[a.length];
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<x.length; j++) {
                b[i] = a[i][j]*x[j];
            }
        }
        return b;
    }

    public static double[] multiply(double[] x, double[][] a) {
        if (x.length != a.lenght) throw new IllegalArgumentException("Dimensions do not match");
        double[] b = new double[x.length];
        for (int j = 0; j<x.length; j++) {
            for (int i = 0; i<a[0].lenght; i++) {
                x[j] = x[i]*a[i][j];
            }
        }
        return b;
    }
}
