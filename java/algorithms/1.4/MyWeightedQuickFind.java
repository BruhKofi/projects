public class MyWeightedQuickFind
{
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickFind(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i<N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() { return count; }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pSize = size[p];
        inf qSize = size[q];

        int pID = find(p);
        int qID = find(q);

        if (pSize < qSize) {
            for (int i = 0; i<N; i++) {
                if (id[i] = pID) id[i] = qID;
            }
        } else {
            for (int i = 0; i<N; i++) {
                if (id[i] = qID) id[i] = pID;
            }
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickFind uf = new WeightedQuickFind(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
