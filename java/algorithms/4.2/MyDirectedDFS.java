public class MyDirectedDFS
{
    private boolean[] marked;
    
    public MyDirectedDFS(MyDigraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public MyDirectedDFS(MyDigraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) dfs(G, s);
        }
    }

    private void dfs(MyDigraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));

        Bag<Integer> sources = new Bag<Integer>();
        for (int i = 1; i<args.length; i++) {
            sources.add(Integer.parseInt(args[i]));
        }

        MyDirectedDFS reachable = new MyDirectedDFS(G, sources);
        
        for (int v = 0; v<G.V(); v++) {
            if (reachable.marked(v)) StdOut.print(v + " ");
        }
        StdOut.println();
    }
}
