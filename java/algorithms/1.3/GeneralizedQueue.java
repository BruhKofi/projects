import java.util.NoSuchElementException;

public class GeneralizedQueue<Item>
{
    private int N;
    private Node first;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Item item) {
        N++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item delete(int k) {
        if (k >= N) throw new NoSuchElementException();
        N--;
        Item item = null;
        if (k == 0) {
            item = first.item;
            first = first.next;
            return item;
        }
        Node current = first;
        for (int i = 0; i<k-1; i++) {
            current = current.next;
        }
        item = current.next.item;
        current.next = current.next.next;
        return item;
    }

    public static void main(String[] args) {
        GeneralizedQueue<String> q = new GeneralizedQueue<String>();
        for (String s : args) {
            q.insert(s);
        }
        while (!StdIn.isEmpty()) {
            int k = StdIn.readInt();
            StdOut.println(q.delete(k));
        }
    }
}