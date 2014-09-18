public class RandBag<Item>
{
    private Item[] items;
    private int N;

    public RandBag(int cap) {
        items = (Item[]) new Object[cap];
    }

    public RandBag() {
        this(16);
    }

    public int size() { return N; }

    public void add(Item item) {
        if (N == items.length) resize(2*items.length);
        items[N++] = item;
    }

    public Item peek() {
        int r = StdRandom.uniform(N);
        return items[r];
    }

    private void resize(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i<N; i++) copy[i] = items[i];
        items = copy;
    }

    public static void main(String[] args) {
        RandBag<String> bag = new RandBag<String>();
        while (!StdIn.isEmpty()) bag.add(StdIn.readString());
        for (int i = 0; i<bag.size(); i++) StdOut.println(bag.peek());
    }
}
