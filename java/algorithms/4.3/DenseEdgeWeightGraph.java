import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;
public class DenseEdgeWeightGraph
{
    private double[][] a;

    public DenseEdgeWeightGraph(int V) {
        a = new double[V][V];
    }

    public void addEdge(int v, int w, double weight) {
        if (v < 0 || v > a.length-1) throw new IndexOutOfBoundsException();
        if (w < 0 || w > a.length-1) throw new IndexOutOfBoundsException();
        if (weight <= 0.0) throw new IllegalArgumentException();
        if (hasEdge(v, w)) throw new RuntimeException();
        a[v][w] = weight;
        a[w][v] = weight;
    }

    public boolean hasEdge(int v, int w) {
        return a[v][w] > 0.0;
    }

    public double weight(int v, int w) {
        return a[v][w];
    }

    public Iterable<Integer> adj(int v) {
        Bag<Integer> b = new Bag<Integer>();
        for (int i = 0; i<a.length; i++) {
            if (a[v][i] > 0.0) b.add(i);
        }
        return b;
    }
}
