public class BaconHistogram
{
    public static void main(String[] args) {
        int[] hist = new int[10];
        int noBaconNum = 0;
        MySymbolGraph sg = new MySymbolGraph(args[0], args[1]);
        MyGraph G = sg.G();

        String source = args[2];

        if (!sg.contains(source)) {
            StdOut.println(source + " not in database");
            return;
        }

        int s = sg.index(source);
        MyBreadthFirstPaths bfs = new MyBreadthFirstPaths(G, s);

        for (int w = 0; w < G.V(); w++) {
            if (bfs.hasPathTo(w)) {
                int baconNum = Math.max(bfs.distTo(w)/2 - 1, 0);
                if (baconNum < hist.length) hist[baconNum]++;
            } else {
                noBaconNum++;
            }
        }
        StdOut.println("No connection to Kevin Bacon: " + noBaconNum);
        for (int i = 0; i<hist.length; i++) {
            StdOut.println("Actors with Bacon number " + i + ": " + hist[i]);
        }
    }
}
