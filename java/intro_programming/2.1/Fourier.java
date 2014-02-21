public class Fourier
{

    public static double fourier(double t, int N) {
        double sum = 0.0;
        for (int i = 1; i<=N; i++) {
            sum += Math.cos(i*t);
        }
        return sum/N;
    }
    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdDraw.setXscale(-10.0, 10.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.setPenRadius(0.005);
        double t = -10.0;
        double delta_t = 20.0/N;
        for (int i = 0; i<N; i++) {
            StdDraw.point(t, fourier(t, N));
            t += delta_t;
        }
    }
}
