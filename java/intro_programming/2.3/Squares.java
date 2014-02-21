public class Squares
{
    public static void square1(double x, double y, double sz, int N) {
        if (N == 0) {
            return;
        }
        double x0 = x - sz/2, x1 = x + sz/2;
        double y0 = y - sz/2, y1 = y + sz/2;
        sz /= 2.2;
        square1(x0, y0, sz, N-1);
        square1(x0, y1, sz, N-1);
        square1(x1, y0, sz, N-1);
        square1(x1, y1, sz, N-1);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(x, y, sz);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, sz);
    }

    public static void square2(double x, double y, double sz, int N) {
        if (N == 0) {
            return;
        }
        double x0 = x - sz/2, x1 = x + sz/2;
        double y0 = y - sz/2, y1 = y + sz/2;
        sz /= 2.2;
        square2(x0, y0, sz, N-1);
        square2(x1, y1, sz, N-1);
        square2(x0, y1, sz, N-1);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(x, y, sz);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, sz);
        square2(x1, y0, sz, N-1);
    }

    public static void square3(double x, double y, double sz, int N) {
        if (N == 0) {
            return;
        }
        double x0 = x - sz/2, x1 = x + sz/2;
        double y0 = y - sz/2, y1 = y + sz/2;
        sz /= 2.2;
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(x, y, sz);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, sz);
        square3(x0, y0, sz, N-1);
        square3(x0, y1, sz, N-1);
        square3(x1, y0, sz, N-1);
        square3(x1, y1, sz, N-1);
    }

    
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        square3(0.5, 0.5, 0.3, N);
    }
}
        
