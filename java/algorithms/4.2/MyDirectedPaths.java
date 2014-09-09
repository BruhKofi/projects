public class MyDirectedPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;


    public MyDirectedPaths(MyDigraph G, int s) {
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

    public Iterable<Integer> pathTo(int v) {
        if (!marked[v]) return null;
        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) stack.push(x);
        stack.push(s);
        return stack;
    }


    public boolean reachable(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDirectedPaths paths = new MyDirectedPaths(G, Integer.parseInt(args[1]));
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            if (paths.reachable(v)) {
                for (int w : paths.pathTo(v)) StdOut.print(w + " ");
                StdOut.println();
            } else {
                StdOut.println("Vertex " + v + " not reachable");
            }
        }
    }
}
