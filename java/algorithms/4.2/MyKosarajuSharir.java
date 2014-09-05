public class MyKosarajuSharir
{
    public int count;
    public int[] id;
    public boolean[] marked;

    public MyKosarajuSharir(MyDigraph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        MyDepthFirstOrder order = new MyDepthFirstOrder(G);
        for (int v : order.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(MyDigraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public int count() {
        return count;
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }
}
