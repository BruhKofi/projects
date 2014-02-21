public class MatrixSquare
{
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int N = StdIn.readInt();
        StdIn.readInt();
        double[][] p = new double[N][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                p[i][j] = StdIn.readDouble();
            }
        }
        for (int t = 0; t<T; t++) {
            double[][] temp = new double[N][N];
            for (int i = 0; i<N; i++) {
                for (int j = 0; j<N; j++) {
                    for (int k = 0; k<N; k++) {
                        temp[i][j] += p[i][k]*p[k][j];
                    }
                }
            }
            for (int i = 0; i<N; i++) {
                for (int j = 0; j<N; j++) {
                    p[i][j] = temp[i][j];
                }
            }
        }
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                StdOut.printf("%8.5f ", p[i][j]);
            }
            StdOut.println();
        }
    }
}
