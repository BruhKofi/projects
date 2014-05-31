import java.util.Arrays;
import java.util.Comparator;
public class MyBinarySearchST<Key extends Comparable<Key>, Value>
{
    private int N;
    private Item[] items;

    private class Item
    {
        Key key;
        Value value;

        public Item(Key key, Value value) {
            this.key = key; this.value = value;
        }
    }

    public class keyOrder implements Comparator<Item>
    {
        public int compare(Item v, Item w) {
            return v.key.compareTo(w.key);
        }
    }
    
    public MyBinarySearchST() {
        items = new Item[2];
    }
    
    public MyBinarySearchST(Item[] a) {
        N = a.length;
        items = a;
        Arrays.sort(items, new keyOrder());
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void put(Key key, Value value) {
        if (N == items.length) resize(2*items.length);
        int i = rank(key);
        if (i < N && items[i].key.compareTo(key) == 0) {
            items[i].value = value;
            return;
        }
        for (int j = N; j > i; j--) {
            items[j].key = items[j-1].key;
            items[j].value = items[j-1].value;
        }
        items[i].key = key;
        items[i].value = value;
        N++;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && key.compareTo(items[i].key) == 0) return items[i].value;
        else return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i<N; i++) {
            q.enqueue(items[i].key);
        }
        return q;
    }

    private int rank(Key key) {
        int lo = 0;
        int hi = N-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(items[mid].key);
            if (cmp > 0) lo = mid+1;
            else if (cmp < 0) hi = mid - 1;
            else return mid;
        }
        return lo;
    }

    private void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i<N; i++) {
            copy[i] = new Item(items[i].key, items[i].value);
        }
        items = copy;
    }
}
