public class MyBreadthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public MyBreadthFirstPaths(MyGraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        bfs(G, s);
    }

    public MyBreadthFirstPaths(MyGraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        bfs(G, sources);
    }

    private void bfs(MyGraph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v<G.V(); v++) distTo[v] = Integer.MAX_VALUE;
        q.enqueue(s);
        distTo[s] = 0;
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = 1 + distTo[v];
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    private void bfs(MyGraph G, Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v<G.V(); v++) distTo[v] = Integer.MAX_VALUE;
        for (int s : sources) {
            distTo[s] = 0;
            marked[s] = true;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = 1 + distTo[v];
                    q.enqueue(w);
                }
            }
        }
    }
                

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int w) {
        Stack<Integer> path = new Stack<Integer>();
        if (!hasPathTo(w)) return path;
        int v;
        for (v = w; distTo[v] != 0; v = edgeTo[v]) {
            path.push(v);
        }
        path.push(v);
        return path;
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        MyBreadthFirstPaths paths = new MyBreadthFirstPaths(G, 0);
        for (int v = 0; v<G.V(); v++) {
            if (paths.hasPathTo(v)) {
                StdOut.print(0 + "->" + v + ": ");
                for (int w : paths.pathTo(v)) StdOut.print(w + " ");
                StdOut.println();
            }
        }
    }
}
