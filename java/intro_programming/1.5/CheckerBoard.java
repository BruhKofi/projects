public class CheckerBoard
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        double delta = 1.0/N;
        double width = delta/2.0;
        StdOut.println(width);
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                double x = width + i*delta;
                double y = width + j*delta;
                StdOut.println(x + " " + y);
                if ((i+j)%2 == 0) {
                    StdDraw.setPenColor(StdDraw.RED);
                } else {
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                StdDraw.filledSquare(x, y, width);
            }
        }
    }
}
