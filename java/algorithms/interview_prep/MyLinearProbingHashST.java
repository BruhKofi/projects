public class MyLinearProbingHashST<Key, Value>
{
    private Key[] keys;
    private Value[] vals;
    private int N;
    private int M;

    public MyLinearProbingHashST() {
        this(16);
    }

    public MyLinearProbingHashST(int cap) {
        M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        MyLinearProbingHashST<Key, Value> t = new MyLinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i<M; i++) {
            if (keys[i] != null) t.put(keys[i], vals[i]);
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }
    
    public void put(Key key, Value val) {
        if (N >= M/2) resize(2*M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1)%M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i+1)%M) {
            if (keys[i].equals(key)) return vals[i];
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) i = (i+1)%M;
        keys[i] = null;
        vals[i] = null;
        i = (i+1)%M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i+1)%M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i<M; i++) {
            if (keys[i] != null) q.enqueue(keys[i]);
        }
        return q;
    }

    public static void main(String[] args) {
        MyLinearProbingHashST<String, Integer> hashST = new MyLinearProbingHashST<String, Integer>();
        int freq = Integer.parseInt(args[0]);
        int length = Integer.parseInt(args[1]);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (hashST.contains(s)) hashST.put(s, hashST.get(s) + 1);
            else hashST.put(s, 1);
        }

        for (String s : hashST.keys()) if (s.length() >= length && hashST.get(s) >= freq) StdOut.println(s + ": " + hashST.get(s));
    }
}
