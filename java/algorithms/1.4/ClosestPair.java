import java.util.Arrays;

public class MyClosestPair
{
    public static void main(String[] args) {
        StdOut.println("line");
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        StdOut.println("line");

        Arrays.sort(a);

        double min_dist = Double.MAX_VALUE;
        double n1 = 0.0;
        double n2 = 0.0;
        for (int i = 1; i<N; i++) {
            if (Math.abs(a[i-1] - a[i]) < min_dist) {
                min_dist = Math.abs(a[i-1] - a[i]);
                n1 = a[i-1];
                n2 = a[i];
            }
        }

        StdOut.println("Closest pair: " + n1 + " " + n2);
    }
}
            
