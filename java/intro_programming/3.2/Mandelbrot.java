import java.awt.Color;

public class Mandelbrot
{
    private static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t<max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

    public static void main(String[] args) {
        double xc = Double.parseDouble(args[0]);
        double yc = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);
        int N = 512;
        Picture pic = new Picture(N, N);
        int[][] colors = new int[256][3];
        int l = 0;
        while (!StdIn.isEmpty()) {
            int n1 = StdIn.readInt();
            int n2 = StdIn.readInt();
            int n3 = StdIn.readInt();
            colors[l][0] = n1;
            colors[l][1] = n2;
            colors[l][2] = n3;
            l++;
        }
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                double x0 = xc - size/2 + size*i/N;
                double y0 = yc - size/2 + size*j/N;
                Complex z0 = new Complex(x0, y0);
                int t = mand(z0, 255);
                Color c = new Color(colors[t][0], colors[t][1], colors[t][2]);
                pic.set(i, N-1-j, c);
            }
        }
        pic.show();
    }
}
