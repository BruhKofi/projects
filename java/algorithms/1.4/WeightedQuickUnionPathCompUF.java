public class WeightedQuickUnionPathCompUF
{
    private int[] id;
    private int count;
    private int[] sz;
    private int sites;
    
    public WeightedQuickUnionPathCompUF(int N) {
        id = new int[N];
        sz = new int[N];
        sites = N;
        count = N;
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
        int t = p;
        while (t != id[t]) t = id[t];
        while (p != t) {
            int c = id[p];
            id[p] = t;
            p = c;
        }
        return t;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else { id[j] = i; sz[i] += sz[j]; }
        count--;
    }

    public int newSite() {
        if (sites == id.length) resize(2*sites);
        id[sites] = sites;
        sz[sites] = 1;
        sites++;
        count++;
        return sites;
    }

    private void resize(int newSize) {
        int[] szCopy = new int[newSize];
        int[] idCopy = new int[newSize];
        for (int i = 0; i<sites; i++) {
            szCopy[i] = sz[i];
            idCopy[i] = id[i];
        }
        sz = szCopy;
        id = idCopy;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionPathCompUF uf = new WeightedQuickUnionPathCompUF(N);
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
