public class MyTopoSort
{
    private Iterable<Integer> order;
    
    public MyTopoSort(MyDigraph G) {
        MyDiCycle cycle = new MyDiCycle(G);
        if (!cycle.isDAG()) throw new IllegalArgumentException("Input graph must be a directed cycle");
        DirectedOrder directedOrder = new DirectedOrder(G);
        order = directedOrder.reversePost();
    }

    public Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        MyTopoSort topoSort = new MyTopoSort(new MyDigraph(new In(args[0])));
        for (int x : topoSort.order()) StdOut.print(x + " ");
        StdOut.println();
    }
}
