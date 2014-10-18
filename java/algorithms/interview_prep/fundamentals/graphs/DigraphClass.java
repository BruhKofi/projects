/*
  Implementation of a digraph
*/
public class DigraphClass
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public DigraphClass(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v<V; v++) adj[v] = new Bag<Integer>();
    }

    public DigraphClass(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int e = 0; e<E; e++) {
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
        DigraphClass G = new DigraphClass(in);
        StdOut.println(G);
    }
}
