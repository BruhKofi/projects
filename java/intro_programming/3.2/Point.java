public class Point
{
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point q) {
        return Math.sqrt((x - q.x) * (x - q.x) + (y - q.y) * (y - q.y));
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point[] points = new Point[N];
        for (int i = 0; i<N; i++) {
            points[i] = new Point(StdIn.readDouble(), StdIn.readDouble());
        }
        for (int i = 0; i<N; i++) {
            for (int j = i+1; j<N; j++) {
                StdOut.println(points[i].distanceTo(points[j]));
            }
        }
    }
}
