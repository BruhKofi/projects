public class RandomEuclideanGraph
{
    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        MyEuclideanGraph G = new MyEuclideanGraph(V);
        Point2D[] points = new Point2D[V];

        for (int i = 0; i<V; i++) {
            double d1 = StdRandom.uniform();
            double d2 = StdRandom.uniform();
            Point2D p = new Point2D(d1, d2);
            
            points[i] = p;
        }

        double d = Double.parseDouble(args[1]);
        SET<Point2D> set = new SET<Point2D>();
        int e = 0;
        for (int i = 0; i<V; i++) {
            for (int j = i+1; j<V; j++) {
                if (points[i].distanceTo(points[j]) < d) {
                    set.add(points[i]);
                    set.add(points[j]);
                    e++;
                    StdOut.println(points[i].x() + " " + points[i].y() + " " + points[j].x() + " " + points[j].y());
                }
            }
        }
        StdOut.println(set.size());
        StdOut.println(e);
        for (int i = 0; i<V; i++) {
            for (int j = i+1; j<V; j++) {
                if (points[i].distanceTo(points[j]) < d) {
                    StdOut.println(points[i].x() + " " + points[i].y() + " " + points[j].x() + " " + points[j].y());
                }
            }
        }
    }
}
