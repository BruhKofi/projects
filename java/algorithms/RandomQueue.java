import java.lang.UnsupportedOperationException;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class ArrayRandomQueue<Item> implements Iterable<Item>
{
    private int N;
    private Item[] a;

    public ArrayRandomQueue() {
        a = (Item[]) new Object[2];
    }

    public void enqueue(Item item) {
        a[N++] = item;
    }

    public Item dequeue() {
        int r = StdRandom.uniform(N);
        exch(a, N-1, r);
        Item item = a[N-1];
        a[--N] = null;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Item sample() {
        int r = StdRandom.uniform(N);
        exch(a, N-1, r);
        return a[N-1];
    }

    private void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i<N; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    private void shuffle(Item[] a) {
        for (int i = 0; i<N; i++) {
            int r = i + StdRandom.uniform(N - i);
            exch(a, i, r);
        }
    }

    private void exch(Item[] a, int i, int j) {
        Item t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public Iterator<Item> iterator() {
        return new ArrayRandomQueueIterator();
    }

    private class ArrayRandomQueueIterator implements Iterator<Item>
    {
        int current = 0;
        int size = N;
        
        public boolean hasNext() {
            if (size != N) throw new ConcurrentModificationException();
            return current < N;
        }

        public Item next() {
            if (size != N) throw new ConcurrentModificationException();
            return a[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ArrayRandomQueue<String> rq = new ArrayRandomQueue<String>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }

        for (String s : rq) {
            StdOut.println(s);
        }

        for (int i = 0; i<5; i++) {
            StdOut.println(rq.sample());
        }

        while (true) {
            StdOut.println(rq.dequeue());
        }
    }
        
}