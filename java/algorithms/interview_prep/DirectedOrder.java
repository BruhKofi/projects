public class DirectedOrder
{
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DirectedOrder(MyDigraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();

        for (int v = 0; v<G.V(); v++) if (!marked[v]) dfs(G, v);
    }

    private void dfs(MyDigraph G, int v) {
        marked[v] = true;
        pre.enqueue(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public static void main(String[] args) {
        DirectedOrder order = new DirectedOrder(new MyDigraph(new In(args[0])));
        StdOut.print("preorder: ");
        for (int x : order.pre()) StdOut.print(x + " ");
        StdOut.println();
        StdOut.print("postorder: ");
        for (int x : order.post()) StdOut.print(x + " ");
        StdOut.println();
        StdOut.print("reverse postorder: ");
        for (int x : order.reversePost()) StdOut.print(x + " ");
        StdOut.println();
    }
}
