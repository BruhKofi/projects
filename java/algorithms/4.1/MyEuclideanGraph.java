public class MyEuclideanGraph
{
    private int V;
    private int E;
    private Bag<Point2D>[] adj;
    private ST<Point2D, Integer> st;
    private Point2D[] keys;

    public MyEuclideanGraph(int V) {
        this.V = V;
        adj = (Bag<Point2D>[]) new Bag[V];
        st = new ST<Point2D, Integer>();
        for (int i = 0; i<V; i++) {
            adj[i] = new Bag<Point2D>();
        }
    }

    public MyEuclideanGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        int k = 0;
        for (int i = 0; i<E; i++) {
            Point2D p1 = new Point2D(in.readDouble(), in.readDouble());
            Point2D p2 = new Point2D(in.readDouble(), in.readDouble());
            StdOut.println(p1 + " : " + p2);
            if (!st.contains(p1)) st.put(p1, k++);
            if (!st.contains(p2)) st.put(p2, k++);
            addEdge(p1, p2);
        }

        keys = new Point2D[st.size()];
        for (Point2D p : st.keys()) {
            keys[st.get(p)] = p;
        }
    }

    private void addEdge(Point2D v, Point2D p) {
        adj[st.get(v)].add(p);
        adj[st.get(p)].add(v);
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
                p.drawTo(w);
            }
        }
    }

    public static void main(String[] args) {
        MyEuclideanGraph eg = new MyEuclideanGraph(new In(args[0]));
        eg.show();
    }
}
