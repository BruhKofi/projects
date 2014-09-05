import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;
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

    public MyDigraph(MyDigraph G) {
        this(G.V());
        for (int v = 0; v<G.V(); v++) {
            for (int w : G.adj(v)) {
                addEdge(v, w);
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        if (v == w) throw new IllegalArgumentException("self loops are disallowed");
        if (hasEdge(v, w)) throw new IllegalArgumentException("parallel edges are disallowed");
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex must be between " + 0 + " and " + (V-1));
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException("vertex must be between " + 0 + " and " + (V-1));
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

    public boolean hasEdge(int v, int w) {
        for (int k : adj(v)) if (w == k) return true;
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        MyDigraph that = (MyDigraph) obj;
        if (V() != that.V()) return false;
        if (E() != that.E()) return false;
        for (int v = 0; v<V(); v++) {
            for (int w : adj(v)) {
                boolean match = false;
                for (int k : that.adj(v)) {
                    if (w == k) {
                        match = true;
                        break;
                    }
                }
                if (!match) return false;
            }
        }
        return true;
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
        StdOut.println(new MyDigraph(G));
        StdOut.println(G.hasEdge(0, 5));
    }
}
