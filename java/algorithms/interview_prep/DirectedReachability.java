public class DirectedReachability
{
    private boolean[] marked;
    private int cnt;

    public DirectedReachability(MyDigraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(MyDigraph G, int v) {
        cnt++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean reachable(int w) {
        return marked[w];
    }

    public int cnt() {
        return cnt;
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        DirectedReachability dfs = new DirectedReachability(G, 0);
        StdOut.println(dfs.cnt());
        for (int v = 0; v<G.V(); v++) StdOut.println(v + " " + dfs.reachable(v));
    }
}
