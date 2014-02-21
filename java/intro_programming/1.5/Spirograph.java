public class Spirograph
{
    public static void main(String[] args) {
        double R = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);
        double a = Double.parseDouble(args[2]);

        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1, 1);
            
        final int points = 1000;

        final double T = 10.0;

        double deltax = T/points;

        for (int i = 0; i<points; i++) {
            double x = (R+r)*Math.cos(i*deltax) - (r+a)*Math.cos((R+r)*i*deltax/r);
            double y = (R+r)*Math.sin(i*deltax) - (r+a)*Math.sin((R+r)*i*deltax/r);
            StdDraw.point(x, y);
        }
    }
}
