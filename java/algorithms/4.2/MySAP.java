public class MySAP
{
    private int commonAncestor;
    private Bag<Integer> sap;
    
    public MySAP(MyDigraph G, int v, int w) {
        MyDirectedShortestPaths vPaths = new MyDirectedShortestPaths(G, v);
        MyDirectedShortestPaths wPaths = new MyDirectedShortestPaths(G, w);
        int minPathLength = Integer.MAX_VALUE;
        commonAncestor = -1;
        for (int k = 0; k<G.V(); k++) {
            if (vPaths.hasPathTo(k) && wPaths.hasPathTo(k) && (vPaths.distTo(k) + wPaths.distTo(k)) < minPathLength) {
                commonAncestor = k;
            }
        }

        if (commonAncestor != -1) {
            sap = new Bag<Integer>();
            for (int k : vPaths.pathTo(commonAncestor)) sap.add(k);
            for (int k : wPaths.pathTo(commonAncestor)) sap.add(k);
        }
    }

    public int commonAncestor() {
        return commonAncestor;
    }

    public Iterable<Integer> sap() {
        return sap;
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MySAP sap = new MySAP(G, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        StdOut.println(sap.commonAncestor());
        if (sap.commonAncestor() != -1) {
            for (int w : sap.sap()) StdOut.print(w + " ");
        }
        StdOut.println();
    }
}
