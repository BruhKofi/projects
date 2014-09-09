public class Vyssotsky
{
    private boolean[] marked;
    private SET<MyEdge> mst;

    public Vyssotsky(MyEdgeWeightedGraph G) {
        mst = new SET<MyEdge>();
        marked = new boolean[G.V()];
        visit(G, 0);
    }

    public void visit(MyEdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (MyEdge e : G.adj(v)) {
            mst.add(e);
            int w = 
