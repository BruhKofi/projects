public class Library
{
    private static final int DOUBLE_BOUND = 10000;
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = makeDoubleArray(N);
        print(a);
        normalize(a);
        print(a);
    }

    private static void print(double[] a) {
        for (int i = 0; i<a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    private static double[] makeDoubleArray(int N) {
        double[] a = new double[N];
        for (int i = 0; i<a.length; i++) a[i] = randomDouble(DOUBLE_BOUND);
        return a;
    }

    private static double randomDouble(int N) {
        return N*Math.random();
    }
    
    public static void normalize(double[] a) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        int N = a.length;
        for (int i = 0; i<N; i++) {
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
        }

        for (int i = 0; i<N; i++) {
            a[i] -= min;
            a[i] /= (max-min);
        }
    }
}
