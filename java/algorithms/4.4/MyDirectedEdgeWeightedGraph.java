public class MyDirectedEdgeWeightedGraph
{
    private Bag<MyDirectedEdge>[] adj;
    private final int V;
    private int E;

    public MyDirectedEdgeWeightedGraph(int V) {
        this.V = V;
        adj = (Bag<MyDirectedEdge>[]) new Bag[V];
        for (int v = 0; v<V; v++) adj[v] = new Bag<MyDirectedEdge>();
    }

    public MyDirectedEdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int e = 0; e<E; e++) {
            MyDirectedEdge edge = new MyDirectedEdge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(edge);
        }
    }

    public void addEdge(MyDirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<MyDirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<MyDirectedEdge> edges() {
        Bag<MyDirectedEdge> bag = new Bag<MyDirectedEdge>();
        for (int v = 0; v<V; v++) for (MyDirectedEdge e : adj(v)) bag.add(e);
        return bag;
    }
}
