import java.util.NoSuchElementException;
public class MySeparateChainingHashST<Key, Value>
{
    private MySequentialSearchST<Key, Value>[] st;
    private int Q;

    public MySeparateChainingHashST() {
        this(997);
    }

    public MySeparateChainingHashST(int sz) {
        Q = sz;
        st = (MySequentialSearchST<Key, Value>[]) new MySequentialSearchST[Q];
        for (int i = 0; i<Q; i++) st[i] = new MySequentialSearchST<Key, Value>();
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % Q;
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public boolean contains(Key key) {
        return st[hash(key)].contains(key);
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i<Q; i++) {
            for (Key key : st[i].keys()) q.enqueue(key);
        }
        return q;
    }

    public static void main(String[] args) {
        MySeparateChainingHashST<String, Integer> hashST = new MySeparateChainingHashST<String, Integer>();
        int l = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (hashST.contains(s)) hashST.put(s, hashST.get(s) + 1);
            else hashST.put(s, 1);
        }

        for (String s : hashST.keys()) if (hashST.get(s) > l) StdOut.println(s + ": " + hashST.get(s));
    }
}
