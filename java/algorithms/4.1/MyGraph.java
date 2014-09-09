import java.lang.IllegalArgumentException;
public class MyGraph
{
    private Bag<Integer>[] adj;
    private final int V;
    private int E;

    public MyGraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i<V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public MyGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i<E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public MyGraph(MyGraph G) {
        this(G.V());
        for (int v = 0; v<G.V(); v++) {
            for (int w : G.adj(v)) addEdgeInternal(v, w);
        }
        this.E /= 2;
    }
        

    public void addEdge(int v, int w) {
        //        if (v == w) throw new IllegalArgumentException("self loops are disallowed");
        //        for (int k : adj[v]) if (k == w) throw new IllegalArgumentException("parallel edges are disallowed");
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public void addEdgeInternal(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public boolean hasEdge(int v, int w) {
        for (int k : adj[v]) if (k == w) return true;
        return false;
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

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges\n");
        for (int v = 0; v<V; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) s.append(w + " ");
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            try {
                G.addEdge(v, w);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
