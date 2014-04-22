import java.util.NoSuchElementException;
import java.util.Iterator;
import java.lang.UnsupportedOperationException;

public class RingBuffer<Item> implements Iterable<Item>
{
    private int N;
    private Item[] buffer;

    public RingBuffer(int M) {
        buffer = (Item[]) new Object[M];
    }

    public Item pop() {
        if (N == 0) throw new NoSuchElementException();
        Item item = buffer[0];
        for (int i = 1; i<N; i++) {
            buffer[i-1] = buffer[i];
        }
        N--;
        return item;
    }

    public void push(Item item) {
        if (N < buffer.length) buffer[N++] = item;
        else {
            for (int i = 1; i<N; i++) {
                buffer[i-1] = buffer[i];
            }
            buffer[N-1] = item;
        }
    }

    public Iterator<Item> iterator() {
        return new RingIterator();
    }

    private class RingIterator implements Iterator<Item>
    {
        int current = 0;
        
        public boolean hasNext() {
            return current < buffer.length;
        }

        public Item next() {
            return buffer[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RingBuffer<String> rb = new RingBuffer<String>(5);
        for (String s : args) {
            rb.push(s);
        }

        for (String s : rb) {
            StdOut.println(s);
        }

        while (!StdIn.isEmpty()) {
            if ("-".equals(StdIn.readString())) {
                StdOut.println(rb.pop());
            }
        }
    }
}