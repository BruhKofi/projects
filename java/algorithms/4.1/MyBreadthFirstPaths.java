public class MyBreadthFirstPaths
{
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private final int s;

    public MyBreadthFirstPaths(MyGraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        distTo[s] = 0;
        this.s = s;
        bfs(G, s);
    }

    private void bfs(MyGraph G, int v) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[v] = true;
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int s = queue.dequeue();
            for (int w : G.adj(s)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = s;
                    distTo[w] = distTo[s] + 1;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        MyBreadthFirstPaths paths = new MyBreadthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++) {
            StdOut.print(s + " to " + v + " in " + paths.distTo(v) + " steps: ");
            if (paths.hasPathTo(v)) {
                for (int x : paths.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
            }
            StdOut.println();
        }
    }
}
                
