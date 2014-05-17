import java.util.NoSuchElementException;

public class UnorderedArrayPQ<Key extends Comparable<Key>>
{
    private int N;
    private Key[] a = (Key[]) new Comparable[1];

    public void insert(Key key) {
        if (N == a.length) resize(2*a.length);
        a[N++] = key;
    }

    public Key removeMax() {
        if (N == 0) throw new NoSuchElementException();
        if (N == a.length/4) resize(a.length/2);
        Key max = a[0];
        int maxIndex = 0;
        for (int i = 0; i<N; i++) {
            if (a[i].compareTo(max) > 0) {
                max = a[i];
                maxIndex = i;
            }
        }
        exch(a, maxIndex, --N);
        Key value = a[N];
        a[N] = null;
        return value;
    }

    private void resize(int size) {
        Key[] copy = (Key[]) new Comparable[size];
        for (int i = 0; i<N; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    private void exch(Key[] a, int i, int j) {
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        UnorderedArrayPQ<String> pq = new UnorderedArrayPQ<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("*")) StdOut.println(pq.removeMax());
            else pq.insert(s);
        }
    }
}
