public class MyMST
{
    private Queue<MyEdge>[] msts;
    private boolean[] marked;
    private MinPQ<MyEdge> pq;

    public MyMST(MyEdgeWeightedGraph G) {
        EWCC cc = new EWCC(G);
        marked = new boolean[G.V()];
        pq = new MinPQ<MyEdge>();
        msts = (Queue<MyEdge>[]) new Queue[cc.count()];


        for (int i = 0; i<cc.count(); i++) {
            msts[i] = new Queue<MyEdge>();
            for (int v = 0; v<G.V(); v++) {
                if (cc.id(v) != i) continue;
                if (!marked[v]) {
                    prim(G, cc, v);
                }
            }
        }
    }

    private void prim(MyEdgeWeightedGraph G, EWCC cc, int v) {
        visit(G, v);
        while (!pq.isEmpty()) {
            MyEdge e = pq.delMin();
            int u = e.either();
            int w = e.other(u);
            if (marked[u] && marked[w]) continue;
            msts[cc.id(v)].enqueue(e);
            if (!marked[u]) visit(G, u);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(MyEdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (MyEdge e : G.adj(v)) {
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder(msts.length + " minimum spanning trees\n");
        for (int i = 0; i<msts.length; i++) {
            s.append("MST " + i + "\n");
            for (MyEdge e : msts[i]) {
                s.append("\t" + e + "\n");
            }
            s.append("\n");
        }
        return new String(s);
    }

    public static void main(String[] args) {
        MyEdgeWeightedGraph G = new MyEdgeWeightedGraph(new In(args[0]));
        MyMST F = new MyMST(G);
        StdOut.println(F);
    }
}
