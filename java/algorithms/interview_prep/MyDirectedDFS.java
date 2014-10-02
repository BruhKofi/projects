public class MyDirectedDFS
{
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public MyDirectedDFS(MyDigraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(MyDigraph G, int v) {
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
        Stack<Integer> path = new Stack<Integer>();
        if (!hasPathTo(v)) return path;
        for (int x = v; x != s; x = edgeTo[x]) path.push(x);
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDirectedDFS dfs = new MyDirectedDFS(G, 0);
        for (int v = 0; v<G.V(); v++) {
            StdOut.print(v + ": ");
            if (dfs.hasPathTo(v)) {
                for (int x : dfs.pathTo(v)) StdOut.print(x + " ");
            }
            StdOut.println();
        }
    }
}
