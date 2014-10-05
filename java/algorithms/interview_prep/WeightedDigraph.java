public class WeightedDigraph
{
    private final int V;
    private int E;
    private Bag<WeightedDiedge>[] adj;
    private final String VERTEX_INDEX_ERROR = "Vertex must be between " + 0 + " and ";

    public WeightedDigraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        adj = (Bag<WeightedDiedge>[]) new Bag[V];
        for (int v = 0; v<V; v++) adj[v] = new Bag<WeightedDiedge>();
    }

    public WeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i<E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            if (v < 0 || v >= V) throw new IndexOutOfBoundsException(VERTEX_INDEX_ERROR + (V-1));
            if (w < 0 || w >= V) throw new IndexOutOfBoundsException(VERTEX_INDEX_ERROR + (V-1));
            WeightedDiedge e = new WeightedDiedge(v, w, weight);
            addEdge(e);
        }
    }

    public void addEdge(WeightedDiedge e) {
        adj[e.from()].add(e);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<WeightedDiedge> adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException(VERTEX_INDEX_ERROR + (V-1));
        return adj[v];
    }

    public Iterable<WeightedDiedge> edges() {
        Bag<WeightedDiedge> bag = new Bag<WeightedDiedge>();
        for (int v = 0; v<V(); v++) for (WeightedDiedge e : adj(v)) bag.add(e);
        return bag;
    }

    public int outDegree(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException(VERTEX_INDEX_ERROR + (V-1));
        return adj[v].size();
    }

    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices " + E + " edges" + NEWLINE);
        for (int v = 0; v<V(); v++) {
            sb.append(v + ": ");
            for (WeightedDiedge e : adj(v)) sb.append(e + " ");
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WeightedDigraph G = new WeightedDigraph(new In(args[0]));
        StdOut.println(G);
    }
}
