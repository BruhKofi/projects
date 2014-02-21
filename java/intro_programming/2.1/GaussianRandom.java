public class GaussianRandom
{
    public static double gaussian() {
        double r, x, y;
        do {
            x = uniform(-1.0, 1.0);
            y = uniform(-1.0, 1.0);
            r = x*x + y*y;
        } while (r >= 1 || r == 0);
        return x*Math.sqrt(-2 * Math.log(r)/r);
    }

    public static double uniform(double a, double b) {
        return (b-a) * Math.random() + a;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[20];
        for (int j = 0; j<N; j++) {
            double g = gaussian();
            for (int i = 0; i<20; i++) {
                if (g > 0 && g < (i+1) * 0.5) {
                    a[i]++;
                    break;
                }
            }
        }
        StdDraw.setYscale(0.0, 0.2);
        StdDraw.setXscale(0.0, 20);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i<20; i++) {
            StdOut.println(((double)(a[i]))/N);
            StdDraw.point(i+ 1.0/20, ((double)(a[i]))/N);
        }
    }
}
