/*
  Do work when preprocessing to support fast queries
*/
public class SingleSourcePaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public SingleSourcePaths(AnUndirectedGraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(AnUndirectedGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int w = v; w != s; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        AnUndirectedGraph G = new AnUndirectedGraph(new In(args[0]));
        SingleSourcePaths p = new SingleSourcePaths(G, 0);
        for (int v = 0; v<G.V(); v++) {
            if (p.hasPathTo(v)) {
                StdOut.print(v + ": ");
                for (int w : p.pathTo(v)) StdOut.print(w + " ");
            }
            StdOut.println();
        }
    }
}
