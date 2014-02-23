import java.awt.Color;

public class ComplexNewton
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Complex[] roots = new Complex[4];
        roots[0] = new Complex(1, 0);
        roots[1] = new Complex(0, 1);
        roots[2] = new Complex(-1, 0);
        roots[3] = new Complex(0, -1);
        Color[] colors = new Color[5];
        colors[0] = Color.BLUE;
        colors[1] = Color.RED;
        colors[2] = Color.WHITE;
        colors[3] = Color.GREEN;
        colors[4] = new Color(255, 255, 255);

        Picture pic = new Picture(N, N);
        double sz = 2.0;

        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                double x0 = -sz/2.0 + sz*(double)i/N;
                double y0 = -sz/2.0 + sz*(double)j/N;
                Complex z0 = new Complex(x0, y0);
                Complex z = newton(z0);
                for (int k = 0; k<roots.length; k++) {
                    if (z.minus(roots[k]).abs() < 1e-12) {
                        pic.set(i, j, colors[k]);
                        break;
                    } else {
                        pic.set(i, j, colors[4]);
                    }
                }
            }
        }
        pic.show();
    }

    private static Complex newton(Complex z0) {
        Complex z = z0;
        for (int t = 0; t<100; t++) {
            Complex z4 = z.times(z).times(z).times(z);
            Complex z3 = z.times(z).times(z);
            Complex top = z4.minus(new Complex(1, 0));
            Complex bottom = z3.times(new Complex(4, 0));
            Complex quotient = top.divides(bottom);
            z = z.minus(quotient);
        }
        return z;
    }
}
