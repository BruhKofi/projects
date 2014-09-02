public class MyDegreesOfSep
{
    public static void main(String[] args) {
        MySymbolGraph sg = new MySymbolGraph(args[0], args[1]);

        MyGraph G = sg.G();
        String source = args[2];

        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        MyBreadthFirstPaths bfs = new MyBreadthFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        StdOut.println("    " + sg.name(v));
                    }
                } else {
                    StdOut.println("Not connected");
                }
            } else {
                StdOut.println("Not in database");
            }
        }
    }
}
