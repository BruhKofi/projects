public class FreqTable<Key>
{
    private LinearProbingHashST<Key, Integer> table;

    public FreqTable() {
        table = new LinearProbingHashST<Key, Integer>();
    }

    public void hit(Key key) {
        if (!table.contains(key)) table.put(key, 1);
        else table.put(key, table.get(key) + 1);
    }

    public int count(Key key) {
        if (table.get(key) == null) return 0;
        return table.get(key);
    }

    public void display() {
        for (Key key : table.keys()) {
            StdOut.println(key + ": " + count(key));
        }
    }

    public static void main(String[] args) {
        FreqTable<String> ft = new FreqTable<String>();
        while (!StdIn.isEmpty()) {
            ft.hit(StdIn.readString());
        }
        ft.display();
    }
}
