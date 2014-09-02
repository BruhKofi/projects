public class MyCycles
{
    public boolean[] marked;
    private boolean hasCycle;

    public MyCycles(MyGraph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) dfs(G, v, v);
        }
    }

    private void dfs(MyGraph G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(u)) {
            if (!marked[w]) {
                dfs(G, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
