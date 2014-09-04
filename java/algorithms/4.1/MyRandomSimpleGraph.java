public class MyRandomSimpleGraph
{
    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);

        MyGraph G = new MyGraph(V);

        for (int i = 0; i<E; i++) {
            int v = StdRandom.uniform(V);
            int w = v;
            do {
                w = StdRandom.uniform(V);
            } while (w == v || G.hasEdge(v, w));
            G.addEdge(v, w);
        }
        StdOut.println(G);
    }
}
