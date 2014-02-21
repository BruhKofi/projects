public class BouncingBall
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        
        double[][] balls = new double[N][2];
        double[][] v = new double[N][2];
        for (int i = 0; i<N; i++) {
            balls[i][0] = 2.0*Math.random() - 1;
            balls[i][1] = 2.0*Math.random() - 1;
            v[i][0] = 0.01*Math.random();
            v[i][1] = 0.01*Math.random();
        }

        double radius = 0.05;
        while (true) {
            StdDraw.clear();
            for (int i = 0; i<N; i++) {
                //StdDraw.setPenColor(StdDraw.GRAY);
                //StdDraw.filledCircle(balls[i][0], balls[i][1], radius);
                if (Math.abs(balls[i][0] + v[i][0]) + radius > 1.0) v[i][0] = -v[i][0];
                if (Math.abs(balls[i][1] + v[i][1]) + radius > 1.0) v[i][1] = -v[i][1];
                if (i == 0) {
                    v[i][1] -= 0.002;
                } else if (i == 1) {
                    v[i][1] -= 0.002*0.166;
                }
                
                balls[i][0] += v[i][0];
                balls[i][1] += v[i][1];
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.filledCircle(balls[i][0], balls[i][1], radius);
            }
            StdDraw.show(20);

        }
    }
}
