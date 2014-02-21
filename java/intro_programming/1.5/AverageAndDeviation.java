public class AverageAndDeviation
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] input = new double[N];
        double total = 0.0;
        double dev = 0.0;
        for (int i = 0; i<N; i++) {
            double a = StdIn.readDouble();
            total += a;
            input[i] = a;
        }
        double mean = total/N;
        for (int i = 0; i<N; i++) {
            dev += (input[i] - mean)*(input[i]-mean);
        }
        dev = dev/(N-1);
        
        StdOut.printf("The average of the numbers is %5.2f and the standard deviation is %5.2f", mean, dev);
        StdOut.println();
    }
}
