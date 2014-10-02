public class MyBipartite
{
    private boolean[] color;
    private boolean[] marked;
    private boolean bipartite;

    public MyBipartite(MyGraph G) {
        color = new boolean[G.V()];
        marked = new boolean[G.V()];
        bipartite = true;
        for (int v = 0; v<G.V(); v++) if (!marked[v]) dfs(G, v);
    }

    private void dfs(MyGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!bipartite) return;
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            } else {
                if (color[w] == color[v]) bipartite = false;
            }
        }
    }

    public boolean isBipartite() {
        return bipartite;
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        MyBipartite B = new MyBipartite(G);
        StdOut.println(B.isBipartite());
    }
}
