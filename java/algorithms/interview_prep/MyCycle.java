public class MyCycle
{
    private boolean[] marked;
    private Iterable<Integer> cycle;
    private int[] edgeTo;


    public MyCycle(MyGraph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v<G.V(); v++) if (!marked[v]) dfs(G, v);
    }

    private void dfs(MyGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (w{//need to ignore reverse edge back to v
                cycle = new Stack<Integer>();
                cycle.push(w);
                for (int x = edgeTo[w]; x != w; x = edgeTo[w]) cycle.push(x);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
