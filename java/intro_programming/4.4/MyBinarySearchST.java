import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.Iterator;

public class MyBinarySearchST<Key extends Comparable<Key>, Value> implements Iterable<Key>
{
    // maintain parallel arrays of key/value pairs in sorted order
    // get -> binary search
    // put -> move larger elements one space to the right
    // use array doubling to maintain the size of the array
    // expect time proportional to the product of the number of string and the number of distinct strings in the input
    
    private int N;
    private Key[] keys;
    private Value[] values;

    public MyBinarySearchST() {
        N = 0;
        keys = (Key[]) new Object[1];
        values = (Value[]) new Object[1];
    }
    
    public void put (Key key, Value v) {
        if (key == null) throw new UnsupportedOperationException();
        Key[] keyCopy = (Key[]) new Object[N+1];
        Value[] valCopy = (Value[]) new Object[N+1];
        int putIndex = 0;
        for (int i = 0; i<N && (key.compareTo(keys[i]) > 0); i++) {
            putIndex++;
            keyCopy[i] = keys[i];
            valCopy[i] = values[i];
        }
        keyCopy[putIndex] = key;
        valCopy[putIndex] = v;
        for (int i = putIndex; i<N; i++) {
            keyCopy[i+1] = keys[i];
            valCopy[i+1] = values[i];
        }
        keys = keyCopy;
        values = valCopy;
    }

    public Value get(Key key) {
        if (N == 0) throw new NoSuchElementException();
        N--;
        int i = Arrays.binarySearch(keys, key);
        return i >= 0 ? values[i] : null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterator<Key> iterator() {
        return new BinarySearchSTIterator();
    }

    private class BinarySearchSTIterator implements Iterator<Key>
    {
        int current = 0;

        public boolean hasNext() {
            return current < N;
        }

        public Key next() {
            return keys[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        MyBinarySearchST<String, String> st = new MyBinarySearchST<String, String>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            String value = StdIn.readString();
            StdOut.println(key + " " + value);
            if (!st.contains(key)) st.put(key, value);
        }

        // for (int i = 0; i<st.N; i++) {
        //     StdOut.println(st.keys[i] + " " + st.values[i]);
        // }

        // for (String key : st) {
        //     StdOut.println(key + " " + st.get(key));
        // }
    }
}