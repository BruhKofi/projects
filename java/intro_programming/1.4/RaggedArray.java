public class RaggedArray
{
    public static void main(String[] args) {
        int N = 10;
        int[][] a = new int[N][0];
        for (int i = 0; i<N; i++) {
            a[i] = new int[i];
            for (int j = 0; j<i; j++) {
                a[i][j] = N*i+j;
            }
        }

        int[][] b = new int[a.length][0];
        for (int i = 0; i<a.length; i++) {
            b[i] = new int[a[i].length];
            for (int j = 0; j<a[i].length; j++) {
                b[i][j] = a[i][j];
            }
        }
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<i; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
