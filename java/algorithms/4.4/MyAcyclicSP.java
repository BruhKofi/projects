public class MyAcyclicSP
{
    private double[] distTo;
    private MyDirectedEdge[] edgeTo;

    public MyAcyclicSP(MyDirectedEdgeWeightedGraph G, int s) {
        EdgeWeightedCycleFinder C = new EdgeWeightedCycleFinder(G);
        if (C.hasCycle()) throw new IllegalArgumentException("Input must be acyclic");

        distTo = new double[G.V()];
        for (int v = 0; v<G.V(); v++) distTo[v] = Double.POSITIVE_INFINITY;
        edgeTo = new MyDirectedEdge[G.V()];

        distTo[s] = 0.0;
        EdgeWeightedTopoSort sort = new EdgeWeightedTopoSort(G);
        for (int v : sort.order()) {
            relax(G, v);
        }
    }

    private void relax(MyDirectedEdgeWeightedGraph G, int v) {
        for (MyDirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
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
        MyAcyclicSP paths = new MyAcyclicSP(G, s);
        for (int v = 0; v<G.V(); v++) {
            StdOut.print(s + " to " + v);
            StdOut.printf(" (%4.2f) ", paths.distTo(v));
            if (paths.hasPathTo(v)) {
                for (MyDirectedEdge e : paths.pathTo(v)) StdOut.print(e + " ");
            }
            StdOut.println();
        }
    }
}
