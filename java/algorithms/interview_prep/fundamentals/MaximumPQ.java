import java.util.Iterator;
import java.util.NoSuchElementException;
public class MaximumPQ<Item extends Comparable<Item>> implements Iterable<Item>
{
    private Item[] items;
    private int N;


    public MaximumPQ(int cap) {
        items = (Item[]) new Comparable[cap+1];
    }

    public MaximumPQ() {
        this(16);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Item item) {
        if (N == items.length-1) resize(2*items.length);
        items[++N] = item;
        swim(N);
    }

    public Item max() {
        if (isEmpty()) throw new NoSuchElementException("PQ underflow");
        return items[1];
    }

    public Item delMax() {
        if (isEmpty()) throw new NoSuchElementException("PQ underflow");
        Item item = items[1];
        exch(1, N--);
        items[N+1] = null;
        sink(1);
        if (N > 0 && (items.length-1)/4 == N) resize(items.length/2);
        return item;
    }

    private void resize(int size) {
        Item[] t = (Item[]) new Comparable[size+1];
        for (int i = 1; i<=N; i++) t[i] = items[i];
        items = t;
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
            exch(k, k/2);
            k /= 2;
        }
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exch(int i, int j) {
        Item t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    public Iterator<Item> iterator() {
        return new PQIterator();
    }

    private class PQIterator implements Iterator<Item>
    {
        private MaximumPQ<Item> pqCopy;

        public PQIterator() {
            pqCopy = new MaximumPQ<Item>();
            for (int i = 1; i<=N; i++) pqCopy.insert(items[i]);
        }
        
        public boolean hasNext() {
            return !pqCopy.isEmpty();
        }

        public Item next() {
            return pqCopy.delMax();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        MaximumPQ<Integer> maxPQ = new MaximumPQ<Integer>();
        for (int i = 1; i<=N; i++) maxPQ.insert(StdRandom.uniform(N));
        while (!maxPQ.isEmpty()) StdOut.println(maxPQ.delMax());
    }
}
