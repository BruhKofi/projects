public class BooleanProduct
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        boolean[][] a = new boolean[N][N];
        boolean[][] b = new boolean[N][N];

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (Math.random()<0.5) {
                    a[i][j] = true;
                }
                if (Math.random()<0.5) {
                    b[i][j] = true;
                }
            }
        }

        boolean c[][] = new boolean[N][N];

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                for (int k = 0; k<N; k++) {
                    c[i][j] = c[i][j] || (a[i][k] && b[k][j]);
                }
            }
        }
        printBooleanArray(a);
        printBooleanArray(b);
        printBooleanArray(c);
    }

    private static void printBooleanArray(boolean[][] a) {
        int N = a.length;
        System.out.print("\t");
        for (int i = 0; i<N; i++) {
            System.out.print(i+1 +"\t");
        }
        System.out.println();
        for (int i = 0; i<N; i++) {
            System.out.print((i+1) + "\t");
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
