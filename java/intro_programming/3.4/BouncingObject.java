import java.awt.Color;
public class BouncingObject
{
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double r;
    private Color color;

    public BouncingObject(double cx, double cy, double _vx, double _vy, double _r) {
        x = cx;
        y = cy;
        vx = _vx;
        vy = _vy;
        r = _r;
        color = new Color((float)StdRandom.uniform(), .8f, .8f);
    }

    public void move() {
        if (Math.abs(x + vx) + r > 1.0) vx = -vx;
        if (Math.abs(y + vy) + r > 1.0) vy = -vy;
        x += vx;
        y += vy;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, r);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        BouncingObject[] b = new BouncingObject[N];

        for (int i = 0; i<N; i++) {
            double cx = StdRandom.uniform();
            double cy = StdRandom.uniform();
            double vx = StdRandom.uniform(0.0, 0.01);
            double vy = StdRandom.uniform(0.0, 0.01);
            double r = StdRandom.uniform(0.0, 0.06);
            b[i] = new BouncingObject(cx, cy, vx, vy, r);
        }
        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1, 1);
        while (true) {
            StdDraw.clear();
            for (int i = 0; i<N; i++) {
                b[i].move();
                b[i].draw();
            }
            StdDraw.show(20);
        }
    }
}
