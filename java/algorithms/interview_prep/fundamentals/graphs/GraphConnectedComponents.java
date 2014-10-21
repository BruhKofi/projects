/*
  Determine the number of connected components in a graph
*/

public class GraphConnectedComponents
{
    private int[] id;
    private boolean[] marked;
    private int cnt;
    private int[] size;

    public GraphConnectedComponents(AnUndirectedGraph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        size = new int[G.V()];
        cnt = 0;
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                cnt++;
            }
        }
    }

    private void dfs(AnUndirectedGraph G, int v) {
        marked[v] = true;
        id[v] = cnt;
        size[cnt]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return cnt;
    }

    public int size(int v) {
        return size[id[v]];
    }

    public static void main(String[] args) {
        AnUndirectedGraph G = new AnUndirectedGraph(new In(args[0]));
        GraphConnectedComponents C = new GraphConnectedComponents(G);
        StdOut.println(C.count());
        for (int v = 0; v<G.V(); v++) {
            StdOut.println("size of " + v + ": " + C.size(v));
        }
    }
}
