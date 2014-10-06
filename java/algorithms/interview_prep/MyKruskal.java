public class MyKruskal
{
    private double weight;
    private Queue<GraphEdge> mst = new Queue<GraphEdge>();

    public MyKruskal(MyWeightedGraph G) {
        MinPQ<GraphEdge> pq = new MinPQ<GraphEdge>();
        for (GraphEdge e : G.edges()) pq.insert(e);

        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            GraphEdge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.enqueue(e);
                weight += e.weight();
            }
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
        MyKruskal MST = new MyKruskal(G);
        for (GraphEdge e : MST.edges()) StdOut.println(e);
        StdOut.println(MST.weight());
    }
}
