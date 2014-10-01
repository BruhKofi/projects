public class MyGraph
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public MyGraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i<V; i++) adj[i] = new Bag<Integer>();
    }

    public MyGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i<E; i++) addEdge(in.readInt(), in.readInt());
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public void addEdge(int v, int w) {
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(V() + NEWLINE);
        sb.append(E() + NEWLINE);
        for (int v = 0; v<V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) sb.append(w + " ");
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        StdOut.println(G);
    }
}
