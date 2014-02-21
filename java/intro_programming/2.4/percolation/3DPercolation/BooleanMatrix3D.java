public class BooleanMatrix3D
{
    public static void print(boolean[][][] a) {
        int N = a.length;
        int M = a[0].length;
        int P = a[0][0].length;

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                for (int k = 0; k<P; k++) {
                    StdOut.print(a[i][j][k] + " ");
                }
                StdOut.println();
            }
            StdOut.println();
        }
    }

    public static boolean[][][] random(int N, double p) {
        boolean[][][] a = new boolean[N][N][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                for (int k = 0; k<N; k++) {
                    a[i][j][k] = StdRandom.bernoulli(p);
                }
            }
        }
        return a;
    }

    public static boolean[][][] readBoolean() {
        int N = StdIn.readInt();
        int M = StdIn.readInt();
        int P = StdIn.readInt();
        boolean a[][][] = new boolean[N][M][P];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                for (int k = 0; k<P; k++) {
                    a[i][j][k] = StdIn.readBoolean();
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        print(random(N, p));
    }
}
