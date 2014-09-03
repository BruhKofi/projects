public class MovieAnalysis
{
    public static void main(String[] args) {
        MySymbolGraph sg = new MySymbolGraph(args[0], args[1]);
        MyGraph G = sg.G();

        MyConnectedComponents cc = new MyConnectedComponents(G);
        StdOut.println("Movie graph has: ");
        StdOut.println(cc.count() + " components");
        RedBlackBST<Integer, Integer> sizes = new RedBlackBST<Integer, Integer>();
        for (int i = 0; i<G.V(); i++) {
            sizes.put(cc.size(i), cc.id(i));
        }
        StdOut.println("Largest component: " + sizes.max());
        StdOut.println("Components with fewer than 10 elements");
        for (Integer i : sizes.keys(0, 10)) {
            StdOut.println(sizes.get(i) + ": " + i);
        }

        MyGraph largestConnectedSubgraph = new MyGraph(sizes.max());
        SeparateChainingHashST<Integer, Integer> st = new SeparateChainingHashST<Integer, Integer>();
        int k = 0;
        
        int compId = 13;
        for (int i = 0; i<G.V(); i++) {
            if (cc.id(i) == compId) {
                if (!st.contains(i)) st.put(i, k++);
                for (int w : G.adj(i)) {
                    if (!st.contains(w)) st.put(w, k++);
                }
            }
        }

        for (int i = 0; i<G.V(); i++) {
            if (cc.id(i) == compId) {
                for (int w : G.adj(i)) {
                    largestConnectedSubgraph.addEdgeInternal(st.get(i), st.get(w));
                }
            }
        }
        StdOut.println("Computing graph statistics");
        MyGraphProperties gp = new MyGraphProperties(largestConnectedSubgraph);
        StdOut.println("Diameter of largest subgraph: " + gp.diameter());
        StdOut.println("Radius of largest subgraph: " + gp.radius());
        StdOut.println("A center of largest subgraph: " + gp.center());
    }
}
