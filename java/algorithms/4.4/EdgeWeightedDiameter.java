public class EdgeWeightedDiameter
{
    public static void main(String[] args) {
        MyDirectedEdgeWeightedGraph G = new MyDirectedEdgeWeightedGraph(new In(args[0]));
        Iterable<MyDirectedEdge> maxPath = new Stack<MyDirectedEdge>();
        double max = Double.NEGATIVE_INFINITY;
        for (int v = 0; v<G.V(); v++) {
            MyDijkstraSP path = new MyDijkstraSP(G, v);
            for (int w = 0; w<G.V(); w++) {
                if (path.distTo(w) > max) {
                    max = path.distTo(w);
                    maxPath = path.pathTo(w);
                }
            }
        }
        int l = 0;
        for (MyDirectedEdge e : maxPath) {
            l++;
            StdOut.println(e);
        }
        StdOut.println("Diameter of graph is " + l);
    }
}
