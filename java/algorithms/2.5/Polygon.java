import java.util.Arrays;

public class Polygon
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MyPoint2D[] points = new MyPoint2D[N];

        for (int i = 0; i<N; i++) {
            points[i] = new MyPoint2D(StdIn.readDouble(), StdIn.readDouble());
        }
        MyPoint2D min = points[0];
        for (int i = 1; i<N; i++) {
            if (points[i].y() <= min.y()) {
                if (points[i].x() < min.x()) min = points[i];
            }
        }
        Arrays.sort(points, min.new aCompare(min));
        for (int i = 0; i<N-1; i++) {
            StdDraw.line(points[i].x(), points[i].y(), points[i+1].x(), points[i+1].y());
        }
        StdDraw.line(points[0].x(), points[0].y(), points[N-1].x(), points[N-1].y());
    }
}
