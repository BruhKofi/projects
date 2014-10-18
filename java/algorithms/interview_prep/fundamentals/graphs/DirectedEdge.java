/*
  Directed edge
*/
public class DirectedEdge
{
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v; this.w = w; this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    public String toString() {
        return String.format("%d->%d %7.5f", from(), to(), weight());
    }

    public static void main(String[] args) {
        DirectedEdge e = new DirectedEdge(2, 5, 7.5);
        StdOut.println(e);
    }
}
