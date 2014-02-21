public class MatMult
{
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int P = Integer.parseInt(args[2]);

        int[][] a = new int[M][N];
        for (int i = 0; i<M; i++) {
            for (int j = 0; j<N; j++) {
                a[i][j] = M*i+j;
            }
        }

        int[][] b = new int[N][P];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<P; j++) {
                b[i][j] = N*i+j;
            }
        }

        int[][] c = matMult(a,b);

        printArray(a);
        System.out.println();
        printArray(b);
        System.out.println();
        printArray(c);
    }

    private static int[][] matMult(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            System.out.println("Dimentions do not match");
        }

        int M = a.length;
        int N = a[0].length;
        int P = b[0].length;

        int[][] c = new int[M][P];

        for (int i = 0; i<M; i++) {
            for (int j = 0; j<P; j++) {
                for (int k = 0; k<N; k++) {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }

    private static void printArray(int[][] a) {
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
