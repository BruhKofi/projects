public class MyCycle
{
    private boolean[] marked;
    private Stack<Integer> cycle;
    private int[] edgeTo;


    public MyCycle(MyGraph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v<G.V(); v++) if (!marked[v]) dfs(G, -1, v);
    }

    private void dfs(MyGraph G, int s, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (hasCycle()) return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            } else if (s != w) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        MyCycle c = new MyCycle(G);
        if (c.hasCycle()) {
            for (int v : c.cycle()) StdOut.print(v + " ");
            StdOut.println();
        }
    }
}
