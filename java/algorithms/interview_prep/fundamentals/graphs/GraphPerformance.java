/*
  Test the performance of DFS vs BFS
*/
public class GraphPerformance
{
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        double dfsTime = 0.0;
        double bfsTime = 0.0;
        Stopwatch sw;
        AnUndirectedGraph G = new AnUndirectedGraph(new In(args[1]));
        for (int t = 0; t<T; t++) {
            sw = new Stopwatch();
            // DFS on G starting from vertex 0
            SingleSourcePaths s = new SingleSourcePaths(G, 0);
            dfsTime += sw.elapsedTime();
            sw = new Stopwatch();
            MultipleSourcePaths p = new MultipleSourcePaths(G, 0);
            bfsTime += sw.elapsedTime();
        }
        StdOut.println("DFS: " + dfsTime);
        StdOut.println("BFS: " + bfsTime);
    }
}
            
