import java.awt.Color;

public class MutableCharge
{
    private double rx;
    private double ry;
    private double q;

    public MutableCharge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx*dx + dy*dy);
    }

    public void increaseCharge(double q0) {
        q += q0;
    }

    public String toString() {
        return q + " at " + "(" + rx + ", " + ry + ")";
    }

    public static void main(String[] args) {
        MutableCharge[] a = new MutableCharge[3];
        a[0] = new MutableCharge(0.4, 0.6, 50);
        a[1] = new MutableCharge(0.5, 0.5, -5);
        a[2] = new MutableCharge(0.6, 0.6, 50);
        int size = 512;
        Picture pic = new Picture(size, size);
        for (int t = 0; t<100; t++) {
            int N = a.length;
            for (int i = 0; i<size; i++) {
                for (int j = 0; j<size; j++) {
                    double x = (double) i / size;
                    double y = (double) j / size;
                    double V = 0.0;
                    for (int k = 0; k<N; k++) {
                        V += a[k].potentialAt(x, y);
                    }
                    int g = 128 + (int) (V / 2.0e10);
                    if (g < 0) g = 0;
                    if (g > 255) g = 255;
                    Color c = new Color(g, g, g);
                    pic.set(i, size - 1 - j, c);
                }
            }
            pic.show();
            a[1].increaseCharge(-2);
        }
    }
}
