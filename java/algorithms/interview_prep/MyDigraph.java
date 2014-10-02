public class MyDigraph
{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public MyDigraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v<V; v++) adj[v] = new Bag<Integer>();
    }

    public MyDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i<E; i++) {
            addEdge(in.readInt(), in.readInt());
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public MyDigraph reverse() {
        MyDigraph rev = new MyDigraph(V());
        for (int v = 0; v<V(); v++) {
            for (int w : adj(v)) {
                rev.addEdge(w, v);
            }
        }
        return rev;
    }

    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(V() + " vertices" + NEWLINE);
        sb.append(E() + " edges" + NEWLINE);
        for (int v = 0; v<V(); v++) {
            sb.append(v + ": ");
            for (int w : adj(v)) sb.append(w + " ");
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDigraph R = G.reverse();
        StdOut.println(G);
        StdOut.println(R);
    }
}
