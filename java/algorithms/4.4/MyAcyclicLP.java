public class MyAcyclicLP
{
    private double[] distTo;
    private MyDirectedEdge[] edgeTo;

    public MyAcyclicLP(MyDirectedEdgeWeightedGraph G, int s) {
        EdgeWeightedCycleFinder C = new EdgeWeightedCycleFinder(G);


        distTo = new double[G.V()];
        for (int v = 0; v<G.V(); v++) distTo[v] = Double.NEGATIVE_INFINITY;
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
            if (distTo[w] < distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] > Double.NEGATIVE_INFINITY;
    }

    public Iterable<MyDirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<MyDirectedEdge> path = new Stack<MyDirectedEdge>();
        for (MyDirectedEdge x = edgeTo[v]; x != null; x = edgeTo[x.from()]) path.push(x);
        return path;
    }

    public static void main(String[] args) {
        MyDirectedEdgeWeightedGraph G = new MyDirectedEdgeWeightedGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        MyAcyclicLP paths = new MyAcyclicLP(G, s);
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
