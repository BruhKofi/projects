/*
  Find out if a digraph has a cycle
*/
public class DirectedCycles
{
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycles(DigraphClass G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        onStack = new boolean[G.V()];
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(DigraphClass G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        DigraphClass G = new DigraphClass(new In(args[0]));
        DirectedCycles C = new DirectedCycles(G);
        StdOut.println(C.hasCycle());
        for (int x : C.cycle()) StdOut.println(x);
    }        
}

    
