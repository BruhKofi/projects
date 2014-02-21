/*************************************************************************
 *  Compilation:  javac PercPlot.java
 *  Execution:    java PercPlot N
 *
 *  This recursive program draws a plot of the percolation probability
 *  (experimental observation) against the site vacancy probability
 *  (control variable).
 *
 *  % java PercPlot N
 *
 *************************************************************************/

public class PercPlot {

    // recursive curve plotting
    public static void curve(int N, int M, double x0, double y0, double x1, double y1) {
        double gap = .01;
        double err = .0025;
        int T = 10000;
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double fxm = 0.0;
        if (M == 0) {
            fxm = Estimate.eval(N, xm, T);
        } else {
            fxm = RectangularEstimate.eval(N, M, xm, T);
        }
        if (x1 - x0 < gap || Math.abs(ym - fxm) < err) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        curve(N, M, x0, y0, xm, fxm);
        StdDraw.filledCircle(xm, fxm, .005);
        curve(N, M, xm, fxm, x1, y1);
    }

    // test client
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = 0;
        if (args.length == 1) {
            M = 0;
        } else {
            M = Integer.parseInt(args[1]);
        }
        long start = System.currentTimeMillis();
        PercPlot.curve(N, M, 0.0, 0.0, 1.0, 1.0);
        long end = System.currentTimeMillis();
        StdOut.println("Elapsed time " + (end - start));
    }
}
