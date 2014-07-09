public class MySeparateChainingHashTable<Key, Value>
{
    private int N;
    private SequentialSearchTable<Key, Value>[] st;

    public MySeparateChainingHashTable() {
        this(997);
    }

    public MySeparateChainingHashTable(int M) {
        N = M;
        st = (SequentialSearchTable<Key, Value>[]) new SequentialSearchTable[M];
        for (int i = 0; i<N; i++) {
            st[i] = new SequentialSearchTable();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % N;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i<N; i++) {
            for (Key key : st[i].keys()) q.enqueue(key);
        }
        return q;
    }

    public static void main(String[] args) {
        MySeparateChainingHashTable<Integer, String> t = new MySeparateChainingHashTable<Integer, String>();
        int M = Integer.parseInt(args[0]);
        for (int i = 0; i<M; i++) {
            int k = StdRandom.uniform(997);
            t.put(k, "Hello world" + k);
        }
        for (Integer key : t.keys()) StdOut.println(key + " " + t.get(key));
    }
}
