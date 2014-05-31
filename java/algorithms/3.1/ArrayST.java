import java.util.NoSuchElementException;
public class ArrayST<Key extends Comparable<Key>, Value>
{
    private int N;
    private Key[] keys;
    private Value[] vals;

    public ArrayST() {
        keys = (Key[]) new Comparable[1];
        vals = (Value[]) new Object[1];
    }
    
    public void put(Key key, Value value) {
        for (int i = 0; i<N; i++) {
            if (key.compareTo(keys[i]) == 0) {
                    vals[i] = value;
                    return;
                }
        }
        if (N == keys.length) resize(2*keys.length);
        keys[N++] = key;
        vals[N-1] = value;
    }

    public Value get(Key key) {
        for (int i = 0; i<N; i++) {
            if (key.compareTo(keys[i]) == 0)
                return vals[i];
        }
        return null;
    }

    public void delete(Key key) {
        for (int i = 0; i<keys.length; i++) {
            if (key.compareTo(keys[i]) == 0) {
                vals[i] = null;
                N--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    public boolean contains(Key key) {
        for (int i = 0; i<N; i++) {
            if (key.compareTo(keys[i]) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i<N; i++) {
            q.enqueue(keys[i]);
        }
        return q;
    }

    private void resize(int size) {
        Key[] keyCopy = (Key[]) new Comparable[size];
        Value[] valCopy = (Value[]) new Object[size];
        for (int i = 0; i<keys.length; i++) {
            keyCopy[i] = keys[i];
            valCopy[i] = vals[i];
        }
        keys = keyCopy;
        vals = valCopy;
    }
}