public class Estimate3D
{
    public static double eval(int N, double p, int M) {
        int count = 0;
        for (int k = 0; k < M; k++) {
            boolean[][][] open = BooleanMatrix3D.random(N, p);
            if (Percolation3D.percolates(open))
                count++;
        }
        return (double) count / M;
    }
    
}
