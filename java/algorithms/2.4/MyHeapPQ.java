public class MyHeapPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;

    public MyHeapPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public MyHeapPQ(Key[] keys) {
        N = keys.length;
        pq = (Key[]) new Comparable[N+1];
        for (int i = 0; i<N; i++) {
            pq[i+1] = keys[i];
        }
        for (int k = N/2; k>=1; k--) {
            sink(k);
        }
        for (int i = 0; i<N; i++) {
            StdOut.println(pq[i+1]);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(j, k)) break;
            exch(j, k);
            k = j;
        }
    }

    public static void main(String[] args) {
        String[] s = StdIn.readAll().split("\\s+");
        MyHeapPQ<String> pq = new MyHeapPQ<String>(s);
        StdOut.println(pq.delMax());
    }
}
