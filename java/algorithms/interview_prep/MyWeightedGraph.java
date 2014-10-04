public class MyWeightedGraph
{
    private final int V;
    private int E;
    private Bag<GraphEdge>[] adj;

    public MyWeightedGraph(int V) {
        this.V = V;
        adj = (Bag<GraphEdge>[]) new Bag[V];
        for (int v = 0; v<V; v++) adj[v] = new Bag<GraphEdge>();
    }

    public MyWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i<E; i++) {
            GraphEdge e = new GraphEdge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(e);
        }
    }

    public void addEdge(GraphEdge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<GraphEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<GraphEdge> edges() {
        Bag<GraphEdge> bag = new Bag<GraphEdge>();
        for (int v = 0; v<V; v++) {
            int loop = 0;
            for (GraphEdge e : adj(v)) {
                if (e.other(v) > v) bag.add(e);
                else if (e.other(v) == v) {
                    if (loop % 2 == 0) bag.add(e);
                    loop++;
                }
            }
        }
        return bag;
    }

    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v<V(); v++) {
            for (GraphEdge e : adj(v)) {
                sb.append(e + " ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyWeightedGraph G = new MyWeightedGraph(new In(args[0]));
        StdOut.println(G);
    }
}
