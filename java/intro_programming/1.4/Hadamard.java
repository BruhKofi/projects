public class Hadamard
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        boolean[][] h = hadamard(N);

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (h[i][j] == true) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    private static boolean[][] hadamard(int N) {
        boolean[][] h = new boolean[N][N];
        if (N == 1) {
            h[0][0] = true;
            return h;
        }
        boolean[][] upper = hadamard(N/2);
        boolean[][] lower = new boolean[N/2][N/2];
        for (int i = 0; i<lower.length; i++) {
            for (int j = 0; j<lower.length; j++) {
                lower[i][j] = !upper[i][j];
            }
        }
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (i>N/2-1 && j>N/2-1) {
                    h[i][j] = lower[i-N/2][j-N/2];
                } else if (i<N/2 && j<N/2) {
                    h[i][j] = upper[i][j];
                } else if (i<N/2 && j>N/2-1) {
                    h[i][j] = upper[i][j-N/2];
                } else {
                    h[i][j] = upper[i-N/2][j];
                }
            }
        }
        return h;
    }
        
}
