import java.util.NoSuchElementException;
public class ResizingArrayHeapPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;

    public ResizingArrayHeapPQ() {
        pq = (Key[]) new Comparable[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        if (N == pq.length-1) resize(2*pq.length);
        pq[++N] = key;
        swim(N);
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException();
        if (N == pq.length/4) resize(pq.length/2);
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k /= 2;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void resize(int size) {
        Key[] copy = (Key[]) new Comparable[size];
        for (int i = 0; i<=N; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    public static void main(String[] args) {
        ResizingArrayHeapPQ<String> p = new ResizingArrayHeapPQ<String>();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("*".equals(s)) StdOut.println(p.delMax());
            else p.insert(s);
        }
    }
}