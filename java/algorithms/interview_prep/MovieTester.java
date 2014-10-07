public class MovieTester
{
    public static void main(String[] args) {
        String source = args[2];
        SymbolTableGraph STGraph = new SymbolTableGraph(args[0], args[1]);
        if (!STGraph.contains(source)) {
            System.err.println(source + " not in database");
            return;
        }

        MyGraph G = STGraph.G();
        int s = STGraph.index(source);
        MyBreadthFirstPaths paths = new MyBreadthFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (!STGraph.contains(sink)) StdOut.println(sink + " not in table");
            else {
                int v = STGraph.index(sink);
                int dist = paths.distTo(v);
                StdOut.println("Distance from " + source + " to " + sink + ": " + Math.max(0, (dist-2)/2));
                for (int w : paths.pathTo(v)) {
                    StdOut.print(STGraph.name(w) + "\t");
                }
                StdOut.println();
            }
        }
    }
}
