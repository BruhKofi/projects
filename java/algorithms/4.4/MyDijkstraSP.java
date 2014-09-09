public class MyDijkstraSP
{
    private double[] distTo;
    private MyDirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public MyDijkstraSP(MyDirectedEdgeWeightedGraph G, int s) {
        distTo = new double[G.V()];
        for (int v = 0; v<G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;
        edgeTo = new MyDirectedEdge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) relax(G, pq.delMin());
    }

    private void relax(MyDirectedEdgeWeightedGraph G, int v) {
        for (MyDirectedEdge e : G.adj(v)) {
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

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<MyDirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<MyDirectedEdge> path = new Stack<MyDirectedEdge>();
        for (MyDirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
             path.push(e);
        }
        return path;
    }

    public static void main(String[] args) {
        MyDirectedEdgeWeightedGraph G = new MyDirectedEdgeWeightedGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        MyDijkstraSP sp = new MyDijkstraSP(G, s);

        for (int v = 0; v<G.V(); v++) {
            StdOut.print(s + " to " + v);
            StdOut.printf(" (%4.2f): ", sp.distTo(v));
            if (sp.hasPathTo(v)) {
                    for (MyDirectedEdge e : sp.pathTo(v)) StdOut.print(e + " ");
            }
            StdOut.println();
        }
    }
}
