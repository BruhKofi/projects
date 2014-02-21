public class RandomSurfer
{
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int N = StdIn.readInt();
        StdIn.readInt();
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        double[][] p = new double[N][N];

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                p[i][j] = StdIn.readDouble();
            }
        }

        int page = 0;

        int[] freq = new int[N];

        for (int t = 1; t<=T; t++) {
            double r = Math.random();
            double sum = 0.0;
            for (int i = 0; i<N; i++) {
                sum += p[page][i];
                if (r<sum) {
                    page = i;
                    break;
                }
            }
            freq[page]++;
        }
        for (int i = 0; i<N; i++) {
            StdOut.printf("%8.5f", (double)freq[i]/T);
            StdOut.println();
            StdDraw.filledCircle(i, 0.5, (double)freq[i]/T); 
        }
        StdOut.println();
        StdOut.println("Hitting times");
    }
    
}
