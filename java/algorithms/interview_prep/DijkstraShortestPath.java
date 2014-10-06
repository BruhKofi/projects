public class DijkstraShortestPath
{
    private IndexMinPQ<Double> pq;
    private WeightedDiedge[] edgeTo;
    private double[] distTo;

    public DijkstraShortestPath(WeightedDigraph G, int s) {
        pq = new IndexMinPQ<Double>(G.V());
        edgeTo = new WeightedDiedge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v<G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(WeightedDigraph G, int v) {
        for (WeightedDiedge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    
    public Iterable<WeightedDiedge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<WeightedDiedge> path = new Stack<WeightedDiedge>();
        for (WeightedDiedge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) path.push(e);
        return path;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public static void main(String[] args) {
        WeightedDigraph G = new WeightedDigraph(new In(args[0]));
        DijkstraShortestPath SPT = new DijkstraShortestPath(G, 0);
        for (int v = 0; v<G.V(); v++) {
            if (SPT.hasPathTo(v)) {
                StdOut.print("Path to " + v + ": ");
                for (WeightedDiedge e : SPT.pathTo(v)) StdOut.print(e + " ");
                StdOut.println();
            }
        }
    }
}
