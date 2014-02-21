public class RandStatsTest
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] uniform = new int[N];
        double[] uniformDouble = new double[N];
        boolean[] bern = new boolean[N];
        double[] gauss = new double[N];
        
        for (int i = 0; i<N; i++) {
            uniform[i] = StdRandom.uniform(N);
            uniformDouble[i] = StdRandom.uniform();
            bern[i] = StdRandom.bernoulli(0.5);
            gauss[i] = StdRandom.gaussian();
        }

        StdOut.printf("Mean: %8.5f\tVariance: %8.5f\n", StdStats.mean(uniform), StdStats.var(uniform));
        StdOut.printf("Mean: %8.5f\tVariance: %8.5f\n", StdStats.mean(uniformDouble), StdStats.var(uniformDouble));
        //        StdOut.printf("Mean: %8.5f\tVariance: %8.5f", StdStats.mean(bern), StdStats.var(bern));
        StdOut.printf("Mean: %8.5f\tVariance: %8.5f\n", StdStats.mean(gauss), StdStats.var(gauss));
    }
}
