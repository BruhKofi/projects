/*
  Undirected, weighted edge
*/
public class UndirectedEdge implements Comparable<UndirectedEdge>
{
    private final int v;
    private final int w;
    private final double weight;

    public UndirectedEdge(int v, int w, double weight) {
        this.v = v; this.w = w; this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int k) {
        if (k == v) return w;
        else if (k == w) return v;
        else throw new IllegalArgumentException("Invalid endpoint");
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(UndirectedEdge other) {
        if (this.weight() > other.weight()) return 1;
        else if (this.weight() < other.weight()) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("%d-%d %2.2f", v, w, weight);
    }

    public static void main(String[] args) {
        UndirectedEdge e = new UndirectedEdge(5, 2, 0.5);
        StdOut.println(e);
    }
}
