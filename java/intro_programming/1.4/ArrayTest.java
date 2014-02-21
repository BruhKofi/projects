public class ArrayTest
{
    public static void main(String[] args) {
        int N = 10;
        double[] a = new double[N];
        double[] b = new double[N];

        for (int i = 0; i<N; i++) {
            a[i] = Math.random();
            b[i] = Math.random();
        }
        System.out.println(dist(a, b));

        String[] me = {"m", "a", "t", "t", "h", "e", "w"};
        for (int i = 0; i<me.length; i++) {
            System.out.print(me[i]);
        }
        System.out.println();
        reverse(me);
        for (int i = 0; i<me.length; i++) {
            System.out.print(me[i]);
        }
        System.out.println();

        boolean[][] bool = new boolean[N][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (Math.random() < 0.5) {
                    bool[i][j] = true;
                }
            }
        }
        printBooleanArray(bool);
        int[] z = {1, 2, 3};
        int[] y = {1, 2, 3};
        System.out.println(z == y);
    }

    private static double dist(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i<a.length; i++) {
            sum += a[i]*b[i];
        }
        return Math.sqrt(sum);
    }

    private static void reverse(String[] a) {
        int N = a.length;
        for (int i = 0; i<a.length/2; i++) {
            String t = a[i];
            a[i] = a[N-1-i];
            a[N-1-i] = t;
        }
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
