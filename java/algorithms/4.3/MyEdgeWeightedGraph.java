public class MyEdgeWeightedGraph
{
    private int V;
    private int E;
    private Bag<MyEdge>[] adj;

    public MyEdgeWeightedGraph(int V) {
        this.V = V;
        adj = (Bag<MyEdge>[]) new Bag[V];
        for (int v = 0; v<V; v++) {
            adj[v] = new Bag<MyEdge>();
        }
    }

    public MyEdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i<E; i++) {
            MyEdge e = new MyEdge(in.readInt(), in.readInt(), in.readDouble());
            addEdge(e);
        }
    }

    public void addEdge(MyEdge e) {
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

    public Iterable<MyEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<MyEdge> edges() {
        Bag<MyEdge> bag = new Bag<MyEdge>();
        for (int v = 0; v<V; v++) {
            for (MyEdge e : adj(v)) {
                if (e.other(v) > v) bag.add(e);
            }
        }
        return bag;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(V + " vertices, " + E + " edges\n");
        for (int v = 0; v<V; v++) {
            for (MyEdge e : adj(v)) s.append(e + "\t");
            s.append("\n");
        }
        return new String(s);
    }

    public static void main(String[] args) {
        MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(new In(args[0]));
        StdOut.println(G);
    }
}
