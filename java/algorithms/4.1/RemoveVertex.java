public class RemoveVertex
{
    private int vertexToRemove;
    private boolean[] marked;

    public RemoveVertex(MyGraph G) {
        marked = new boolean[G.V()];
        dfs(G, 0);
    }

    public int getVertexToRemove() {
        return vertexToRemove;
    }

    private void dfs(MyGraph G, int v) {
        marked[v] = true;
        if (visited(G.adj(v))) {
                vertexToRemove = v;
                return;
        }
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    private boolean visited(Iterable<Integer> bag) {
        for (int w : bag) {
            if (!marked[w]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        RemoveVertex rm = new RemoveVertex(G);
        StdOut.println(rm.getVertexToRemove());
    }
}
        
