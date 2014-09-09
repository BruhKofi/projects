public class EdgeWeightedCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    
    public EdgeWeightedCycle(MyEdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) {
                dfs(G, -1, v);
            }
        }
    }

    private void dfs(MyEdgeWeightedGraph G, int u, int v) {
        marked[v] = true;
        for (MyEdge e : G.adj(v)) {
            if (cycle != null) return;
            int w = e.other(v);
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            }

            else if (u != v) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<> cycle {
    }
}
