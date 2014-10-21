/*
  Use BFS to return the shortest path from any source vertex to another vertex
*/
import java.util.Collections;
public class MultipleSourcePaths
{
    private int[] edgeTo;
    private boolean[] marked;
    private int[] distTo;

    public MultipleSourcePaths(AnUndirectedGraph G, int s) {
        this(G, Collections.singleton(s));
    }

    public MultipleSourcePaths(AnUndirectedGraph G, Iterable<Integer> s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v<G.V(); v++) distTo[v] = Integer.MAX_VALUE;
        for (int w : s) {
            marked[w] = true;
            distTo[w] = 0;
            q.enqueue(w);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
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

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> s = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x]) {
            s.push(x);
        }
        s.push(x);
        return s;
    }

    public int distTo(int v) {
        return distTo[v];
    }

    public static void main(String[] args) {
        AnUndirectedGraph G = new AnUndirectedGraph(new In(args[0]));
        MultipleSourcePaths p = new MultipleSourcePaths(G, 0);
        for (int v = 0; v<G.V(); v++) {
            if (p.hasPathTo(v)) {
                StdOut.print(v + ": ");
                for (int w : p.pathTo(v)) StdOut.print(w + " ");
            }
            StdOut.println();
        }
    }
}
