/*
  Class for undirected graph
*/
public class AnUndirectedGraph
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public AnUndirectedGraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i<V; i++) adj[i] = new Bag<Integer>();
    }

    public AnUndirectedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i<E; i++) {
            addEdge(in.readInt(), in.readInt());
        }
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
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V() + " vertices " + E() + " edges\n");
        for (int v = 0; v<V(); v++) {
            sb.append(v + ": ");
            for (Integer k : adj(v)) sb.append(k + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        AnUndirectedGraph G = new AnUndirectedGraph(in);
        StdOut.println(G);
    }
}
