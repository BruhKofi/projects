public class MyConnectedComponents
{
    private boolean[] marked;
    private int count;
    private int[] id;
    private int[] sz;

    public MyConnectedComponents(MyGraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s<G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
        getSizes();
    }

    private void dfs(MyGraph G, int s) {
        marked[s] = true;
        id[s] = count;
        for (int w : G.adj(s)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    private void getSizes() {
        sz = new int[count];
        for (int i = 0; i<id.length; i++) {
            sz[id[i]]++;
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public int size(int w) {
        return sz[id[w]];
    }

    public static void main(String[] args) {
        MyGraph G = new MyGraph(new In(args[0]));
        MyConnectedComponents cc = new MyConnectedComponents(G);
        int M = cc.count();
        StdOut.println(M + " components");
        Queue<Integer>[] comps = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i<M; i++) {
            comps[i] = new Queue<Integer>();
        }
        for (int v = 0; v<G.V(); v++) {
            comps[cc.id(v)].enqueue(v);
        }
        for (int i = 0; i<M; i++) {
            for (int v : comps[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}
        
