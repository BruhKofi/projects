public class EWCC
{
    private int count;
    private int[] id;
    private boolean[] marked;
    private int[] size;

    public EWCC(MyEdgeWeightedGraph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        size = new int[G.V()];
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(MyEdgeWeightedGraph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (MyEdge e : G.adj(v)) {
            int w = e.other(v);
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int size(int v) {
        return size[id[v]];
    }
}
