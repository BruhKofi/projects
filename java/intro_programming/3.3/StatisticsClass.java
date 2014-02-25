public class StatisticsClass
{
    private int N;
    private double sum;
    private double sqrSum;

    public void addDataPoint(double d) {
        N++;
        sum += d;
        sqrSum += (d*d);
    }

    public int points() { return N; }

    public double mean() { return sum / N; }

    public double var() {
        double top = sqrSum - (sum*sum) / N;
        return top / N;
    }

    public double stdDev() { return Math.sqrt(var()); }

    public static void main(String[] args) {
        StatisticsClass stat = new StatisticsClass();

        while (!StdIn.isEmpty()) {
            stat.addDataPoint(StdIn.readDouble());
        }

        StdOut.printf("Mean: %8.5f\tVariance: %8.5f\tStandard Deviation: %8.5f\n", stat.mean(), stat.var(), stat.stdDev());
    }
}
