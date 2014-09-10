public class DenseEdgeWeightedDigraph
{
    private double[][] weights;
    private final int V;
    private int E;

    public DenseEdgeWeightedDigraph(int V) {
        this.V = V;
        weights = new double[V][V];
        for (int i = 0; i<V; i++) {
            for (int j = 0; j<V; j++) {
                weights[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    public void addEdge(int v, int w, double weight) {
        weights[v][w] = weight;
    }

    public boolean hasEdge(int v, int w) {
        return weights[v][w] != Double.POSITIVE_INFINITY;
    }

    public double weight(int v, int w) {
        if (hasEdge(v, w)) return 0.0;
        return weights[v][w];
    }

    public Iterable<Integer> adj(int v) {
        Bag<Integer> b = new Bag<Integer>();
        for (int i = 0; i<V; i++) {
            if (weights[v][i] != Double.POSITIVE_INFINITY) b.add(i);
        }
        return b;
    }
}
