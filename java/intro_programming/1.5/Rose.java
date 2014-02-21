public class Rose
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        StdDraw.setYscale(-1, 1);
        StdDraw.setXscale(-1, 1);

        final int points = 10000;
        double deltax = 2.0*Math.PI/points;

        for (int i = 0; i<points; i++) {
            double r = Math.sin(N*i*deltax);
            double theta = i*deltax;
            double x = r*Math.cos(theta);
            double y = r*Math.sin(theta);
            StdDraw.point(x, y);
        }
    }
}
