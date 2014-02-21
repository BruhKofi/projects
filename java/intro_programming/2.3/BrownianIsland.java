public class BrownianIsland
{
    public static void curve(double x0, double y0, double x1, double y1, double var, double s) {
        if (x1 - x0 < 0.001) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        double xm = (x0 + x1)/2;
        double ym = (y0 + y1)/2;
        double deltay = StdRandom.gaussian(0, Math.sqrt(var));
        double deltax = StdRandom.gaussian(0, Math.sqrt(var));
        curve(x0, y0, xm+deltax, ym+deltay, var/s, s);
        curve(xm+deltax, ym+deltay, x1, y1, var/s, s);
    }

    public static void main(String[] args) {
        double H = Double.parseDouble(args[0]);
        double s = Math.pow(2, 2*H);
        curve(0.5, 0.5, 0.51, 0.51, 0.05, s);
    }
}
