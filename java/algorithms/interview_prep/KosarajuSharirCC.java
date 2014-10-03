public class KosarajuSharirCC
{
    private int[] id;
    private boolean[] marked;
    private int cnt;

    public KosarajuSharirCC(MyDigraph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        MyDigraph R = G.reverse();
        DirectedOrder directedOrder = new DirectedOrder(R);
        Iterable<Integer> order = directedOrder.reversePost();
        for (int v : order) {
            if (!marked[v]) {
                dfs(G, v);
                cnt++;
            }
        }
    }

    private void dfs(MyDigraph G, int v) {
        marked[v] = true;
        id[v] = cnt;
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

    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        KosarajuSharirCC cc = new KosarajuSharirCC(G);
        StdOut.println(cc.count() + " connected components");
        for (int v = 0; v<G.V(); v++) {
            StdOut.print(v + ": ");
            for (int w = 0; w<G.V(); w++) {
                if (cc.connected(v, w)) {
                    StdOut.print(w + " ");
                }
            }
            StdOut.println();
        }
    }
}
    
