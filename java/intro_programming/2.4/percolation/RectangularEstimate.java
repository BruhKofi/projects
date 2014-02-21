public class RectangularEstimate
{
    public static double eval(int N, int M, double p, int T) {
        int count = 0;
        for (int k = 0; k < T; k++) {
            boolean[][] open = RectangularPercolation.random(N, M, p);
            if (RectangularPercolation.percolates(open))
                count++;
        }
        return (double) count / T;
    }


    public static void main(String[] args) {
        int    N = Integer.parseInt(args[0]);
        int    M = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        int    T = Integer.parseInt(args[3]);
        double q = eval(N, M, p, T);
        StdOut.println(q);
    }
}
