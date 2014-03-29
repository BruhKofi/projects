import java.util.Iterator;
import java.lang.UnsupportedOperationException;

public class MyRandomQueue<Item> implements Iterable<Item>
{
    private int N;
    private Item[] a;

    public MyRandomQueue() {
        a = (Item[]) new Object[1];
    }
    
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item dequeue() {
        if (N == a.length/4) {
            resize(a.length/2);
        }
        int r = StdRandom.uniform(0, N);
        exch(N-1, r);
        Item item = a[--N];
        a[N] = null;
        return item;
    }

    public Item sample() {
        return a[StdRandom.uniform(0, N)];
    }

    private void exch(int i, int j) {
        Item t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void resize(int k) {
        Item[] copy = (Item[]) new Object[k];
        for (int i = 0; i<N; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    public MyRandomQueueIterator iterator() {
        return new MyRandomQueueIterator();
    }

    private class MyRandomQueueIterator implements Iterator<Item>
    {
        int current = 0;
        
        public boolean hasNext() {
            return current < N;
        }

        public Item next() {
            return a[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
        

    public static void main(String[] args)
    {
        MyRandomQueue<String> q = new MyRandomQueue<String>();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            q.enqueue(s);
        }
        for (int i = 0; i<q.size(); i++) {
            StdOut.println(q.dequeue());
        }
    }
}
