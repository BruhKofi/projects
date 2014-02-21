public class SichermanDice
{
    public static void main(String[] args) {
        double p = 1.0/6.0;
        double[] die1 = {p, 0.0, p, p, p, p, 0.0, p};
        double[] die2 = {p, 2*p, 2*p, p};

        int[] total1 = new int[13];
        int[] total2 = new int[13];

        int T = Integer.parseInt(args[0]);

        for (int i = 0; i<T; i++) {
            total1[StdRandom.discrete(die1) + StdRandom.discrete(die2) + 2]++;
            total2[StdRandom.uniform(6) + StdRandom.uniform(6) + 2]++;
        }
        int sum1 = StdStats.sum(total1);
        int sum2 = StdStats.sum(total2);
        double[] norm1 = new double[13];
        double[] norm2 = new double[13];
        for (int i = 0; i<norm1.length; i++) {
            norm1[i] = (double)total1[i]/sum1;
            norm2[i] = (double)total2[i]/sum2;
        }
        //        for (int i = 1; i<norm1.length; i++) {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdStats.plotLines(norm1);
            StdDraw.setPenColor(StdDraw.GRAY);
            StdStats.plotLines(norm2);
    }
}
