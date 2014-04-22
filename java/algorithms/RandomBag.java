import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.util.ConcurrentModificationException;

public class RandomBag<Item> implements Iterable<Item>
{
    private int N;
    private Item[] a;

    public RandomBag() {
        a = (Item[]) new Object[2];
    }

    public void add(Item item) {
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }

    public int size() { return N; }

    private void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i<N; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    public Iterator<Item> iterator() {
        return new RandomBagIterator();
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
        

    private class RandomBagIterator implements Iterator<Item>
    {
        private int current = 0;
        private int total = N;

        public RandomBagIterator() {
            shuffle(a);
        }

        public boolean hasNext() {
            if (total != N) throw new ConcurrentModificationException();
            return current < N;
        }

        public Item next() {
            if (total != N) throw new ConcurrentModificationException();
            return a[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomBag<String> bag = new RandomBag<String>();
        while (!StdIn.isEmpty()) {
            bag.add(StdIn.readString());
        }
        for (String s : bag) {
            StdOut.println(s);
        }
        StdOut.println();
        for (String s : bag) {
            StdOut.println(s);
        }
    }
}
