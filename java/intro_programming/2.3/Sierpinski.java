public class Sierpinski
{
    public static void sierpinski(double x0, double y0, double x1, double y1, double x2, double y2, int n) {
        if (n == 0) return;
        StdDraw.line(x0, y0, x1, y1);
        StdDraw.line(x0, y0, x2, y2);
        StdDraw.line(x2, y2, x1, y1);

        double x0new = (x0 + x1)/2.0;
        double y0new = (y0 + y1)/2.0;
        double x1new = (x1 + x2)/2.0;
        double y1new = y0new;
        double x2new = (x0 + x2)/2.0;
        double y2new = y0;

        sierpinski(x0new, y0new, x1new, y1new, x2new, y2new, n-1);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double x0 = 0.0, x1 = 0.5, x2 = 1.0;
        double y1 = 2.0*Math.tan(Math.PI/3.0);
        double y0 = 0.0, y2 = 0.0;
        sierpinski(x0, y0, x1, y1, x2, y2, N);
    }
}
