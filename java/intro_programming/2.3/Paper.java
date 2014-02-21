public class Paper
{
    public static void draw(int n, double sz, double x, double y) {

        if (n == 0) return;
        double x0 = x - sz/2, x1 = x + sz/2;
        double y0 = y - sz/2, y1 = y + sz/2;

        StdDraw.line(x0, y0, x1, y1);
        StdDraw.line(x0, y1, x1, y0);

        draw(n-1, sz/2, x0, y0);
        draw(n-1, sz/2, x0, y1);
        draw(n-1, sz/2, x1, y0);
        draw(n-1, sz/2, x1, y1);
    }

    public static void drawLines(int n, double sz, double x, double y) {
        if (n == 0) return;
        double x0 = x - sz/2, x1 = x + sz/2;
        double y0 = y - sz/2, y1 = y + sz/2;
        if (n%2 == 1) {
            StdDraw.line(x0, y, x1, y);
        } else {
            StdDraw.line(x, y0, x, y1);
        }
        draw(n-1, sz/2, x0, y0);
        draw(n-1, sz/2, x0, y1);
        draw(n-1, sz/2, x1, y0);
        draw(n-1, sz/2, x1, y1);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        drawLines(N, 0.5, 0.5, 0.5);
    }
}
