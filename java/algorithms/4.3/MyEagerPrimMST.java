public class MyEagerPrimMST
{
    private boolean[] marked;
    private double[] distTo;
    private MyEdge[] edgeTo;
    private IndexMinPQ<Double> pq;
    private double weight;

    public MyEagerPrimMST(MyEdgeWeightedGraph G) 
    {
        marked = new boolean[G.V()];
        distTo = new double[G.V()];
        edgeTo = new MyEdge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int v = 0; v<G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            weight += pq.minKey();
            visit(G, pq.delMin());
        }
    }

    private void visit(MyEdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (MyEdge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }
        
    public Iterable<MyEdge> edges() {
        Queue<MyEdge> edges = new Queue<MyEdge>();
        for (int v = 0; v<edgeTo.length; v++) {
            MyEdge e = edgeTo[v];
            if (e != null) edges.enqueue(e);
        }
        return edges;
    }

    public double weight() {
        return weight;
    }

    public static void main(String[] args) {
        MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(new In(args[0]));
        MyEagerPrimMST T = new MyEagerPrimMST(G);
        for (MyEdge e : T.edges()) StdOut.println(e);
        StdOut.println(T.weight());
    }
}
