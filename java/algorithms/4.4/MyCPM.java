public class MyCPM
{
    public static void main(String[] args) {
        int N = StdIn.readInt();

        MyDirectedEdgeWeightedGraph G = new MyDirectedEdgeWeightedGraph(2*N + 2);

        int s = 2*N;
        int t = 2*N + 1;

        for (int i = 0; i<N; i++) {
            double duration = StdIn.readDouble();
            G.addEdge(new MyDirectedEdge(i, i+N, duration));
            G.addEdge(new MyDirectedEdge(s, i, 0.0));
            G.addEdge(new MyDirectedEdge(i+N, t, 0.0));
            int M = StdIn.readInt();
            for (int j = 0; j<M; j++) {
                int precedent = StdIn.readInt();
                G.addEdge(new MyDirectedEdge(i+N, precedent, 0.0));
            }
        }

        MyAcyclicLP paths = new MyAcyclicLP(G, s);
        StdOut.println("Start times:");
        for (int i = 0; i<N; i++) {
            StdOut.printf("%4d %5.1f\n", i, paths.distTo(i));
        }
        StdOut.printf("Finish time: %5.1f\n", paths.distTo(t));
    }
}

    
