public class MyLazyPrim
{
    private MinPQ<GraphEdge> pq;
    private boolean[] marked;
    private double weight;
    private Queue<GraphEdge> mst;

    public MyLazyPrim(MyWeightedGraph G) {
        mst = new Queue<GraphEdge>();
        marked = new boolean[G.V()];
        pq = new MinPQ<GraphEdge>();

        for (int v = 0; v<G.V(); v++) if (!marked[v]) prim(G, v);
    }

    private void prim(MyWeightedGraph G, int s) {
        scan(G, s);
        while (!pq.isEmpty()) {
            GraphEdge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            weight += e.weight();
            if (!marked[v]) scan(G, v);
            if (!marked[w]) scan(G, w);
        }
    }

    private void scan(MyWeightedGraph G, int v) {
        marked[v] = true;
        for (GraphEdge e : G.adj(v)) {
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<GraphEdge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }

    public static void main(String[] args) {
        MyWeightedGraph G = new MyWeightedGraph(new In(args[0]));
        MyLazyPrim MST = new MyLazyPrim(G);
        for (GraphEdge e : MST.edges()) StdOut.println(e);
        StdOut.println(MST.weight());
    }
}
