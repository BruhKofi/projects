public class MyEuclideanDigraph
{
    private Bag<Point2D>[] adj;
    private int V;
    private int E;
    private ST<Point2D, Integer> st;
    private Point2D[] keys;

    public MyEuclideanDigraph(int V) {
        this.V = V;
        adj = (Bag<Point2D>[]) new Bag[V];
        for (int v = 0; v<V; v++) {
            adj[v] = new Bag<Point2D>();
        }
    }
    
    public MyEuclideanDigraph(In in)
    {
        this(in.readInt());
        int E = in.readInt();
        st = new ST<Point2D, Integer>();
        int k = 0;
        for (int v = 0; v<V; v++) {
            Point2D p1 = new Point2D(in.readDouble(), in.readDouble());
            Point2D p2 = new Point2D(in.readDouble(), in.readDouble());
            if (!st.contains(p1)) st.put(p1, k++);
            if (!st.contains(p2)) st.put(p2, k++);
            addEdge(p1, p2);
        }
        keys = new Point2D[V];
        for (Point2D p : st.keys()) {
            keys[st.get(p)] = p;
        }
    }

    public void addEdge(Point2D v, Point2D w) {
        adj[st.get(v)].add(w);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Point2D> adj(Point2D p) {
        return adj[st.get(p)];
    }

    public void show() {
        for (int i = 0; i<V; i++) {
            Point2D p = keys[i];
            for (Point2D w : adj[i]) {
                drawEdge(p, w);
            }
        }
    }

    private void drawEdge(Point2D p, Point2D w) {
        p.drawTo(w);
        double slope = (p.y() - w.y())/(p.x() - w.x());
    }
}

    public static void main(String[] args) {
        MyEuclideanDigraph eg = new MyEuclideanDigraph(new In(args[0]));
        eg.show();
    }
}
