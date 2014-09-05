public class DigraphTest
{
    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In("tinyDG.txt"));

        MyDigraph copy = new MyDigraph(G);

        assert(copy != G);
        assert(G.equals(copy));

        assert(G.hasEdge(4, 2));

        MyDigraph R = G.reverse();

        assert(R.hasEdge(2, 4));
    }
}
