public class GraphEdge implements Comparable<GraphEdge>
{
    private final int v;
    private final int w;
    private final double weight;

    public GraphEdge(int v, int w, double weight) {
        this.v = v; this.w = w; this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int k) {
        if (k == v) return w;
        else if (k == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(GraphEdge other) {
        if (this.weight() > other.weight()) return 1;
        else if (this.weight() < other.weight()) return -1;
        else return 0;
    }
}
