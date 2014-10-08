public class DAGSAP
{
    private double[] distTo;
    private WeightedDiedge[] edgeTo;

    public DAGSAP(WeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new WeightedDiedge[G.V()];
        for (int v = 0; v<G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;
        MyTopoSort sort = new MyTopoSort(G);
        for (int v : sort.order()) relax(G, v);
    }

    private void relax(WeightedDigraph G, int v) {
        for (WeightedDiedge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }
}
