public class WeightedDiedge
{
    private int v;
    private int w;
    private double weight;

    public WeightedDiedge(int v, int w, double weight) {
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

    @Override
    public String toString() {
        return v + "->" + w + String.format("%5.2f", weight);
    }

    public static void main(String[] args) {
        WeightedDiedge e = new WeightedDiedge(0, 1, 0.5);
        StdOut.println(e);
    }
}
