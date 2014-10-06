public class MyEagerPrim
{
    private IndexMinPQ<Double> pq;
    private boolean[] marked;
    private double[] distTo;
    private GraphEdge[] edgeTo;

    public MyEagerPrim(MyWeightedGraph G) {
        pq = new IndexMinPQ<Double>(G.V());
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v<G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;
        edgeTo = new GraphEdge[G.V()];
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) {
                prim(G, v);
            }
        }
    }

    private void prim(MyWeightedGraph G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    private void scan(MyWeightedGraph G, int v) {
        marked[v] = true;
        for (GraphEdge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<GraphEdge> edges() {
        Queue<GraphEdge> q = new Queue<GraphEdge>();
        for (int v = 0; v<edgeTo.length; v++) {
            GraphEdge e = edgeTo[v];
            if (e != null) q.enqueue(e);
        }
        return q;
    }

    public double weight() {
        double weight = 0.0;
        for (GraphEdge e : edges()) weight += e.weight();
        return weight;
    }

    public static void main(String[] args) {
        MyWeightedGraph G = new MyWeightedGraph(new In(args[0]));
        MyEagerPrim MST = new MyEagerPrim(G);
        for (GraphEdge e : MST.edges()) StdOut.println(e);
        StdOut.println(MST.weight());
    }
}
