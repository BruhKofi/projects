public class ArrayStats
{
    private int points;
    private double[] data;

    public ArrayStats(int N) { data = new double[N]; }

    public void addDataPoint(double d) {
        data[points++] = d;
    }

    public int points() { return points; }

    public double mean() {
        double sum = 0.0;
        for (int i = 0; i<data.length; i++) {
            sum += data[i];
        }
        return sum / points;
    }

    public double var() {
        double sum = 0.0;
        double sumSqr = 0.0;
        for (int i = 0; i<points; i++) {
            sum += data[i];
            sumSqr += (data[i] * data[i]);
        }
        double top = sumSqr - sum*sum / points;
        return top / points;
    }

    public double stdDev() { return Math.sqrt(var()); }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        ArrayStats as = new ArrayStats(N);

        while (!StdIn.isEmpty()) {
            as.addDataPoint(StdIn.readDouble());
        }
        StdOut.printf("Mean: %8.5f\tVariance: %8.5f\tStandard Deviation: %8.5f\n", as.mean(), as.var(), as.stdDev());
    }
}