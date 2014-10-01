public class MyDepthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    
    public MyDepthFirstPaths(MyGraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(MyGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public Iterable<Integer> pathTo(int w) {
        Stack<Integer> q = new Stack<Integer>();
        if (!hasPathTo(w)) return q;
        for (int p = w; p != s; p = edgeTo[p]) q.push(p);
        q.push(s);
        return q;
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        MyDepthFirstPaths paths = new MyDepthFirstPaths(G, 0);
        for (int v = 0; v<G.V(); v++) {
            if (paths.hasPathTo(v)) {
                StdOut.print(0 + "->" + v + ": ");
                for (int w : paths.pathTo(v)) StdOut.print(w + " ");
                StdOut.println();
            }
        }
    }
}
