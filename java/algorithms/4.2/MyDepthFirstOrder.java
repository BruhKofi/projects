public class MyDepthFirstOrder
{
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    private boolean[] marked;

    public MyDepthFirstOrder(MyDigraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<Integer>();
        post = new Queue<Integer>();
        reversePost = new Stack<Integer>();
        for (int v = 0; v<G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(MyDigraph G, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
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
        MyDigraph G = new MyDigraph(new In(args[0]));
        MyDepthFirstOrder order = new MyDepthFirstOrder(G);
        StdOut.print("preorder: ");
        for (int w : order.pre()) {
            StdOut.print(w + " ");
        }
        StdOut.println();
        StdOut.print("postorder: ");
        for (int w : order.post()) {
            StdOut.print(w + " ");
        }
        StdOut.println();
        StdOut.print("reverse postorder: ");
        for (int w : order.reversePost()) {
            StdOut.print(w + " ");
        }
        StdOut.println();
    }
}
