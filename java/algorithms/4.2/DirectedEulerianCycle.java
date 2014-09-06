public class DirectedEulerianCycle
{
    private boolean hasCycle;
    private boolean[] marked;
    private int[] edgeTo;

    public DirectedEulerianCycle(MyDigraph G)
    {
        hasCycle = true;
        MyDegrees degrees = new MyDegrees(G);
        for (int v = 0; v<G.V(); v++) {
            if (degrees.inDegree(v) != degrees.outDegree(v)) hasCycle = false;
        }
        MyKosarajuSharir scc = new MyKosarajuSharir(G);
        if (scc.count() != 1) hasCycle = false;
        if (hasCycle) {
            marked = new boolean[G.V()];
            edgeTo = new int[G.V()];
            dfs(G, 0);
        }
    }

    private void dfs(MyDigraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public Iterable<Ingeter> cycle() {
        Stack<Integer> path = new Stack<Integer>();
        path.push(0);
        for (int x = edgeTo[0]; x != 0; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(0);
    }
}
