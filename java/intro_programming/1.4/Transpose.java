public class Transpose
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[][] a = new int[N][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                a[i][j] = N*i + j;
            }
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<i; j++) {
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
