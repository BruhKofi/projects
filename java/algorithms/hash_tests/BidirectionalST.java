public class BidirectionalST<Key, Value>
{
    private LinearProbingHashST<Key, Value> map;
    private LinearProbingHashST<Value, Key> reverseMap;

    public BidirectionalST() {
        map = new LinearProbingHashST<Key, Value>();
        reverseMap = new LinearProbingHashST<Value, Key>();
    }

    public void put(Key key, Value val) {
        map.put(key, val);
        reverseMap.put(val, key);
    }

    public boolean containsKey(Key key) {
        return map.contains(key);
    }

    public boolean containsValue(Value val) {
        return reverseMap.contains(val);
    }

    public Value getByKey(Key key) {
        return map.get(key);
    }

    public Key getByValue(Value val) {
        return reverseMap.get(val);
    }

    public Iterable<Key> keys() {
        return map.keys();
    }

    public Iterable<Value> values() {
        return reverseMap.keys();
    }

    public void deleteByKey(Key key) {
        Value val = map.get(key);
        map.delete(key);
        reverseMap.delete(val);
    }

    public void deleteByVal(Value val) {
        Key key = reverseMap.get(val);
        reverseMap.delete(val);
        map.delete(key);
    }
}
