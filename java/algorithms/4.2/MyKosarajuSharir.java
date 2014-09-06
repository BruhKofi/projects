public class MyKosarajuSharir
{
    public int count;
    public int[] id;
    public boolean[] marked;

    public MyKosarajuSharir(MyDigraph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        MyDigraph R = G.reverse();
        MyDepthFirstOrder order = new MyDepthFirstOrder(R);
        assert(R.isTopoOrder(order.reversePost()));
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

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyKosarajuSharir scc = new MyKosarajuSharir(G);
        StdOut.println(scc.count());
    }
}
