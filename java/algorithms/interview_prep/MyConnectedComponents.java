public class MyConnectedComponents
{
    private boolean[] marked;
    private int[] id;
    private int[] sz;
    private int cnt;

    public MyConnectedComponents(MyGraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        sz =new int[G.V()];
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                cnt++;
            }
        }
    }

    private void dfs(MyGraph G, int v) {
        marked[v] = true;
        id[v] = cnt;
        sz[cnt]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int id(int v) {
        return id[v];
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int cnt() {
        return cnt;
    }

    public int sz(int v) {
        return sz[id[v]];
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        MyConnectedComponents CC = new MyConnectedComponents(G);
        StdOut.println(CC.cnt());
        for (int v = 0; v<G.V(); v++) {
            StdOut.println(v  + " has id " + CC.id(v) + " and is in component " + CC.sz(v));
        }
    }
}
