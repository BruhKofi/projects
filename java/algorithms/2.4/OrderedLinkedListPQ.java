import java.util.NoSuchElementException;

public class OrderedLinkedListPQ<Key extends Comparable<Key>>
{
    private Node first;

    private class Node
    {
        Key key;
        Node next;
    }

    public void insert(Key key) {
        Node current = first;
        while (current != null && current.key.compareTo(key) > 0) {
            current = current.next;
        }
        Node insertNode = new Node();
        insertNode.key = key;
        insertNode.next = current.next;
        current.next = insertNode;
    }

    public Key removeMax() {
        if (first == null) throw new NoSuchElementException();
        Key key = first.key;
        first = first.next;
        return key;
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