public class MyDegrees
{
    private int[] in;
    private int[] out;
    private Queue<Integer> sources;
    private Queue<Integer> sinks;
    private boolean map;

    public MyDegrees(MyDigraph G) {
        in = new int[G.V()];
        out = new int[G.V()];
        sources = new Queue<Integer>();
        sinks = new Queue<Integer>();
        for (int v = 0; v<G.V(); v++) {
            for (int w : G.adj(v)) {
                out[v]++;
                in[w]++;
            }
        }
        map = true;
        for (int v = 0; v<G.V(); v++) {
            if (in[v] == 0) sources.enqueue(v);
            if (out[v] == 0) sinks.enqueue(v);
            if (out[v] != 1) map = false;
        }
    }

    public boolean isMap() {
        return map;
    }

    public Iterable<Integer> sources() {
        return sources;
    }

    public Iterable<Integer> sinks() {
        return sinks;
    }

    public int inDegree(int v) {
        return in[v];
    }

    public int outDegree(int v) {
        return out[v];
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDegrees D = new MyDegrees(G);
        StdOut.println(D.isMap());
        StdOut.print("sources: ");
        for (int w : D.sources()) StdOut.print(w + " ");
        StdOut.println("\nsinks: ");
        for (int w : D.sinks()) StdOut.print(w + " ");
        StdOut.println();
        StdOut.println(D.inDegree(0));
        StdOut.println(D.outDegree(0));
    }
}
        
