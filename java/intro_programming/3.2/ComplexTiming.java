public class ComplexTiming
{
    public static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t<max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

    public static int doubleMand(double x0, double y0, int max) {
        double x = x0;
        double y = y0;
        for (int t = 0; t<max; t++) {
            if (Math.sqrt(x*x + y*y) > 2.0) return t;
            x = x*x - y*y + x0;
            y = 2*x*y + y0;
        }
        return max;
    }

    public static void main(String[] args) {
        double xc = 0.0;
        double yc = 0.0;
        int N = 512;
        for (double size = 0.25; size < 2.0; size += 0.25) {
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i<N; i++) {
                for (int j = 0; j<N; j++) {
                    double x0 = xc - size/2 + size*i/N;
                    double y0 = yc - size/2 + size*j/N;
                    Complex z0 = new Complex(x0, y0);
                    int t = 512 - mand(z0, 512);
                }
            }
            double complexTime = sw.elapsedTime();

            Stopwatch sw2 = new Stopwatch();
            for (int i = 0; i<N; i++) {
                for (int j = 0; j<N; j++) {
                    double x0 = xc - size/2 + size*i/N;
                    double y0 = yc - size/2 + size*j/N;
                    int t = 512 - doubleMand(x0, y0, 512);
                }
            }
            StdOut.println("Size: " + size + " Complex time/real time: " + complexTime/sw2.elapsedTime());
        }
    }
}
        
