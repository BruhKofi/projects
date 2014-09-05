public class MyDirectedCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public MyDirectedCycle(MyDigraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(MyDigraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : G.adj(v)) {
            if (hasCycle()) return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDirectedCycle cycle = new MyDirectedCycle(G);
        if (cycle.hasCycle()) {
            for (int k : cycle.cycle()) StdOut.print(k + " ");
            StdOut.println();
        }
    }
}
