import java.util.NoSuchElementException;
public class MyDirectedShortestPaths
{
    private boolean marked[];
    private int[] edgeTo;
    private final int s;

    public MyDirectedShortestPaths(MyDigraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(MyDigraph G, int v) {
        Queue<Integer> q = new Queue<Integer>();
        marked[v] = true;
        q.enqueue(v);
        while (!q.isEmpty()) {
            int u = q.dequeue();
            for (int w : G.adj(u)) {
                if (!marked[w]) {
                    edgeTo[w] = u;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    public boolean reachable(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distTo(int v) {
        if (!hasPathTo(v)) throw new NoSuchElementException("No path from " + s + " to " + v);
        int d = 0;
        for (int w : pathTo(v)) d++;
        return d;
    }
        

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDirectedShortestPaths paths = new MyDirectedShortestPaths(G, Integer.parseInt(args[1]));
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            if (paths.hasPathTo(v)) {
                for (int w : paths.pathTo(v)) {
                    StdOut.print(w + " ");
                }
                StdOut.println();
            } else {
                StdOut.println("Vertex " + v + " not reachable");
            }
        }
    }
}
