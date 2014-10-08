public class MyMinPQ<Item>
{
    private Item[] pq;
    private int N;

    public MyMinPQ() {
        pq = (Item[]) new Object[16];
    }

    public MyMinPQ(int cap) {
        pq = (Item[]) new Object[cap];
    }

    public void insert(Item item) {
        if (N == pq.length) resize(2 * pq.length);
        pq[++N] = item;
        swim(N);
    }

    public Item delMin() {
        Item min = pq[1];
        exch(1, N);
        pq[N--] == null;
        sink(1);
        if (N == pq.length/4) resize(pq.length/2);
    }

    private void exch(int i, int j) {
        Item t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 1; i<pq.length; i++) copy[i] = pq[i];
        pq = copy;
    }

    private void sink(int k) {
    }

    private void swim(int k) {
    }
}
        
