public class DenseGraphTest
{
    public static void main(String[] args) {
        DenseEdgeWeightGraph G = new DenseEdgeWeightGraph(Integer.parseInt(args[0]));
        while (!StdIn.isEmpty()) G.addEdge(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
        for (int w : G.adj(0)) StdOut.println(w);
        StdOut.println(G.weight(0, 0));
    }
}
