public class Newton
{
    public static double abs(double x, int indent) {
        for (int i = 0; i<indent; i++) {
            StdOut.print("\t");
        }
        StdOut.println("abs(" + x + ")");
        if (x < 0.0) {
            for (int i = 0; i<indent; i++) {
                StdOut.print("\t");
            }
            StdOut.println("return " + -x);
            return -x;
        } else {
            for (int i = 0; i<indent; i++) {
                StdOut.print("\t");
            }
            StdOut.println("return " + x);
            return x;
        }
    }

    public static double sqrt(double c, int indent) {
        for (int i = 0; i<indent; i++) {
            StdOut.print("\t");
        }
        StdOut.println("sqrt(" + c + ")");
        if (c < 0.0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (abs(t - c/t, 2) > err * t) {
            t = (c/t + t)/2.0;
        }
        for (int i = 0; i<indent; i++) {
            StdOut.print("\t");
        }
        StdOut.println("return " + t);
        return t;
    }

    public static void main(String[] args) {
        int N = args.length;
        double[] a = new double[N];
        StdOut.print("main{");
        for (int i = 0; i<N; i++) {
            a[i] = Double.parseDouble(args[i]);
            StdOut.print(a[i] + " ");
        }
        StdOut.println("}");

        for (int i = 0; i<N; i++) {
            double x = sqrt(a[i], 1);
        }
    }
}
