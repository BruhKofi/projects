public class MyDiCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public MyDiCycle(MyDigraph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        onStack = new boolean[G.V()];

        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(MyDigraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean isDAG() {
        return cycle == null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDiCycle C = new MyDiCycle(G);
        StdOut.println(C.isDAG());
        if (!C.isDAG()) {
            for (int x : C.cycle()) StdOut.print(x + " ");
            StdOut.println();
        }
    }
}
