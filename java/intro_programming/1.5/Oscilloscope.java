public class Oscilloscope
{
    public static void main(String[] args) {
        double Ax = Double.parseDouble(args[0]);
        double wx = Double.parseDouble(args[1]);
        double thetax = Double.parseDouble(args[2]);
        double Ay = Double.parseDouble(args[3]);
        double wy = Double.parseDouble(args[4]);
        double thetay = Double.parseDouble(args[5]);

        final int points = 1000;

        final int T = 10;

        double deltat = 10/(double)points;

        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1.0, 1.0);

        for (int i = 0; i<points; i++) {
            double x = Ax*Math.sin(wx*i*deltat + thetax);
            double y = Ay*Math.sin(wy*i*deltat + thetay);
            StdDraw.point(x, y);
        }
    }
}
