import java.util.NoSuchElementException;

public class UnorderedLinkedListPQ<Key extends Comparable<Key>>
{
    private Node first;

    private class Node
    {
        Key key;
        Node next;
    }

    public void insert(Key key) {
        Node oldFirst = first;
        first = new Node();
        first.key = key;
        first.next = oldFirst;
    }

    public Key removeMax() {
        if (first == null) throw new NoSuchElementException();
        Key max = first.key;
        Node maxNode = first;
        Node a = first;
        for (Node current = first; current.next != null; current = current.next) {
            if (current.next.key.compareTo(max) > 0) {
                max = current.next.key;
                maxNode = current.next;
                a = current;
            }
        }
        a.next = a.next.next;
        maxNode = null;
        return max;
    }

    public static void main(String[] args) {
        UnorderedArrayPQ<String> pq = new UnorderedArrayPQ<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("*")) StdOut.println(pq.removeMax());
            else pq.insert(s);
        }
    }
}