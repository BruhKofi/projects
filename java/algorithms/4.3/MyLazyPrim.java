public class MyLazyPrim
{
    private boolean[] marked;
    private Queue<MyEdge> mst;
    private MinPQ<MyEdge> pq;

    public MyLazyPrim(MyEdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        mst = new Queue<MyEdge>();
        pq = new MinPQ<MyEdge>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            MyEdge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(MyEdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (MyEdge e : G.adj(v)) {
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<MyEdge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (MyEdge e : edges()) weight += e.weight();
        return weight;
    }

    public static void main(String[] args) {
        MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(new In(args[0]));
        MyLazyPrim T = new MyLazyPrim(G);
        for (MyEdge e : T.edges()) StdOut.println(e);
        StdOut.println(T.weight());
    }
}
