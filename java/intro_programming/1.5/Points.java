public class Points
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double [][] points = new double[N][2];
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.setPenRadius(0.01);
        double delta = (Math.PI * 2.0)/N;

        for (int i = 0; i<N; i++) {
            double theta = i*delta;
            double x = Math.cos(theta);
            double y = Math.sin(theta);
            points[i][0] = x;
            points[i][1] = y;
            StdDraw.point(x, y);
        }
        StdDraw.setPenRadius(0.001);
        for (int i = 0; i<N; i++) {
            for (int j = i+1; j<N; j++) {
                if (Math.random() < p) {
                    StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
            }
        }
    }
}
