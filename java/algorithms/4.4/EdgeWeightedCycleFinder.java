public class EdgeWeightedCycleFinder
{
    private boolean[] marked;
    private MyDirectedEdge[] edgeTo;
    private Stack<MyDirectedEdge> cycle;
    private boolean[] onStack;

    public EdgeWeightedCycleFinder(MyDirectedEdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        edgeTo = new MyDirectedEdge[G.V()];
        onStack = new boolean[G.V()];

        for (int v = 0; v<G.V(); v++) dfs(G, v);
    }

    private void dfs(MyDirectedEdgeWeightedGraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (MyDirectedEdge e : G.adj(v)) {
            if (hasCycle()) return;
            int w = e.to();
            if (!marked[w]) {
                edgeTo[w] = e;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<MyDirectedEdge>();
                for (MyDirectedEdge x = edgeTo[w]; x != null; x = edgeTo[x.from()]) {
                    cycle.push(x);
                }
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<MyDirectedEdge> cycle() {
        return cycle;
    }
}
