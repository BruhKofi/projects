import java.util.NoSuchElementException;

public class GeneralizedQueueArray<Item>
{
    private int N;
    private Item[] a;

    public GeneralizedQueueArray() {
        a = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item item) {
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }

    public Item delete(int k) {
        if (k >= N) throw new NoSuchElementException();
        Item item = a[k];
        Item[] copy = (Item[]) new Object[a.length];
        int i = 0;
        int j = 0;
        while (i < N && j < N) {
            if (j == k) j++;
            copy[i++] = a[j++];
        }
        a = copy;
        return item;
    }

    private void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i<N; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }
    
    public static void main(String[] args) {
        GeneralizedQueue<String> q = new GeneralizedQueue<String>();
        for (String s : args) {
            q.insert(s);
        }
        while (!StdIn.isEmpty()) {
            int k = StdIn.readInt();
            StdOut.println(q.delete(k));
        }
    }
}
        