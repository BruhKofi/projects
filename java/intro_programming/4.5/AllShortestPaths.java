public class AllShortestPaths
{
    public static void main(String[] args) {
        In in = new In(args[0]);
        String delim = args[1];
        Graph G = new Graph(in, delim);
        ST<String, PathFinder> allPaths = new ST<String, PathFinder>();
        for (String vertex : G.vertices()) {
            allPaths.put(vertex, new PathFinder(G, vertex));
        }

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            String t = StdIn.readString();
            for (String v : allPaths.get(s).pathTo(t)) {
                StdOut.println(" " + v);
            }
        }
    }
}

    
