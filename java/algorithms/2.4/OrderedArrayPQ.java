import java.util.NoSuchElementException;

public class OrderedArrayPQ<Key extends Comparable<Key>>
{
    private int N;
    private Key[] a = (Key[]) new Comparable[2];

    public void insert(Key key) {
        if (N == a.length) resize(2*a.length);
        a[N++] = key;
        for (int i = 1; i<N; i++) {
            for (int j = i; j>0 && a[j].compareTo(a[j-1]) < 0; j--) exch(a, j, j-1);
        }
    }

    public Key removeMax() {
        if (N == 0) throw new NoSuchElementException();
        if (N == a.length/2) resize(a.length/4);
        Key value = a[--N];
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