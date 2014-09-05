public class MyTopoSort
{
    private Iterable<Integer> order;

    public MyTopoSort(MyDigraph G) {
        MyDirectedCycle cycle = new MyDirectedCycle(G);
        if (!cycle.hasCycle()) {
            MyDepthFirstOrder dfo = new MyDepthFirstOrder(G);
            order = dfo.reversePost();
        }
    }

    public boolean isDAG() {
        return order != null;
    }

    public Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyTopoSort sort = new MyTopoSort(G);
        if (sort.isDAG()) {
            for (int w : sort.order()) StdOut.print(w + " ");
        }
        StdOut.println();
    }
}
