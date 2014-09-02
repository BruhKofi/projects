public class MySearch
{
    private int count;
    private boolean[] marked;

    public MySearch(MyGraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(MyGraph G, int s) {
        marked[s] = true;
        count++;
        for (int w : G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int count() {
        return count;
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        MySearch search = new MySearch(G, s);
        for (int v = 0; v<G.V(); v++) {
            if (search.marked(v)) StdOut.print(v + " ");
        }
        StdOut.println();

        if (search.count() != G.V()) StdOut.print("NOT ");
        StdOut.println("connected");
        StdOut.println(search.count() + " vertices in the cluster containing " + s);
    }
}
