import java.util.Arrays;

public class Pairs
{
    public static void closestPair(double[] a) {
        Arrays.sort(a);
        double min = Double.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i<a.length-1; i++) {
            if (Math.abs(a[i] - a[i+1]) < min) {
                min = Math.abs(a[i] - a[i+1]);
                minIndex = i;
            }
        }
        StdOut.println(a[minIndex] + " " + a[minIndex+1]);
    }

    public static void farthestPair(double[] a) {
        Arrays.sort(a);
        StdOut.println(a[0] +  " " + a[a.length]);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        int i = 0;
        while (!StdIn.isEmpty()) {
            a[i++] = StdIn.readDouble();
        }
        closestPair(a);
        farthestPair(a);
    }
}