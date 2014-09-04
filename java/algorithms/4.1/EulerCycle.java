public class EulerCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private boolean hasEulerCycle = true;
    private boolean hasCycle;
    
    public EulerCycle(MyGraph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v<G.V(); v++) {
            dfs(G, v, v);
        }
    }

    private void dfs(MyGraph G, int v, int u) {
        if (size(G.adj(v))%2 != 0) {
            hasEulerCycle = false;
            return;
        }
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w] || edgeTo[w] != v) {
                edgeTo[w] = v;
                dfs(G, w, v);
            }
            else if (w != u) {
                hasCycle = true;
            }
        }
    }

    private int size(Iterable<Integer> b) {
        int sz = 0;
        for (int i : b) sz++;
        return sz;
    }

    public boolean hasEulerCycle() {
        return hasEulerCycle && hasCycle;
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        EulerCycle ec = new EulerCycle(G);
        StdOut.println(ec.hasEulerCycle());
    }
}
