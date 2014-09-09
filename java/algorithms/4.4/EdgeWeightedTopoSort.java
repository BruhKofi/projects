public class EdgeWeightedTopoSort
{
    private Iterable<Integer> order;

    public EdgeWeightedTopoSort(MyDirectedEdgeWeightedGraph G) {
        EdgeWeightedCycleFinder cycleFinder = new EdgeWeightedCycleFinder(G);
        if (!cycleFinder.hasCycle()) {
            DirectedDepthFirstOrder dfs = new DirectedDepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
