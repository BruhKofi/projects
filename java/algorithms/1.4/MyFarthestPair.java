public class MyFarthestPair
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (int i = 0; i<N; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }

        StdOut.println("Farthest pair: " + min + " " + max);
    }
}
