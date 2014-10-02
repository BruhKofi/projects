public class MyDirectedBFS
{
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public MyDirectedBFS(MyDigraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        
        bfs(G, s);
    }


    private void bfs(MyDigraph G, int s) {
        for (int v = 0; v<G.V(); v++) distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    distTo[w] = 1 + distTo[v];
                    edgeTo[w] = v;
                    q.enqueue(w);
                }
            }
        }
    }
    
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> path = new Stack<Integer>();
        if (!hasPathTo(v)) return path;
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x]) path.push(x);
        path.push(x);
        return path;
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDirectedBFS bfs = new MyDirectedBFS(G, 0);
        for (int v = 0; v<G.V(); v++) {
            StdOut.print(v + ": ");
            if (bfs.hasPathTo(v)) {
                for (int x : bfs.pathTo(v)) StdOut.print(x + " ");
            }
            StdOut.println();
        }
    }
}
