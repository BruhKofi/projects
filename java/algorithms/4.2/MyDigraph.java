public class MyDigraph
{
    private Bag<Integer>[] adj;
    private int E;
    private int V;

    public MyDigraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i<V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public MyDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i<E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public MyDigraph reverse() {
        MyDigraph R = new MyDigraph(V);
        for (int v = 0; v<V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(V + " vertices " + E + " edges\n");
        for (int v = 0; v<V; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return new String(s);
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        StdOut.println(G);
        StdOut.println();
        StdOut.println(G.reverse());
    }
}        
