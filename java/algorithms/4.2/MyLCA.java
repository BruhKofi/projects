public class MyLCA
{
    private int lca;
    SET<Integer> vAncestors;
    SET<Integer> wAncestors;
    
    
    public MyLCA(MyDigraph G, int v, int w) {
        MyDirectedCycle c = new MyDirectedCycle(G);
        if (c.hasCycle()) throw new IllegalArgumentException("Graph must be DAG");
        vAncestors = new SET<Integer>();
        wAncestors = new SET<Integer>();
        MyDegrees deg = new MyDegrees(G);
        
        //For each vertex, determine if it is an ancestor of v or w
        for (int k = 0; k<G.V() && k != w && k !=v; k++) {
            MyDirectedPaths paths = new MyDirectedPaths(G, k);
            if (paths.reachable(v)) vAncestors.add(k);
            if (paths.reachable(w)) wAncestors.add(k);
        }
        SET<Integer> commonAncestors = vAncestors.intersects(wAncestors);
        ST<Integer, Integer> st = new ST<Integer, Integer>();

        //For each source, find shortest distance to each common ancestor
        for (int source : deg.sources()) {
            MyDirectedShortestPaths path = new MyDirectedShortestPaths(G, source);
            for (int anc : commonAncestors) {
                if (path.reachable(anc)) {
                    st.put(path.distTo(anc), anc);
                }
            }
        }
        if (st.size() != 0) lca = st.get(st.max());
        else lca = -1;
        
        
    }

    public int lca() {
        return lca;
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyLCA LCA = new MyLCA(G, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        StdOut.println(LCA.lca());
    }
}
