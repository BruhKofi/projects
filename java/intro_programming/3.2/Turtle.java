import java.awt.Color;

public class Turtle
{
    private double x, y;
    private double angle;

    public Turtle(double x0, double y0, double a0) 
    {
        x = x0;
        y = y0;
        angle = a0;
    }

    public void turnLeft(double delta) {
        angle += delta;
    }

    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step*Math.cos(Math.toRadians(angle));
        y += step*Math.sin(Math.toRadians(angle));
        StdDraw.line(oldx, oldy, x, y);
    }

    public void setXscale(double x, double y) {
        StdDraw.setXscale(x, y);
    }

    public void setYscale(double x, double y) {
        StdDraw.setYscale(x, y);
    }

    public void setCanvasSize(int x, int y) {
        StdDraw.setCanvasSize(x, y);
    }

    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double angle = 360.0/N;
        double step = Math.sin(Math.toRadians(angle/2));
        Turtle turtle = new Turtle(0.5, 0.0, angle/2);
        for (int i = 0; i<N; i++) {
            turtle.goForward(step);
            turtle.turnLeft(angle);
        }
    }
}
