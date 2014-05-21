public class MyLinkedList
{
    private Node first;
    private int N;
    
    private class Node
    {
        Double item;
        Node next;
    }

    public void add(Double item) {
        N++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public int size() {
        return N;
    }

    public static void shuffle(MyLinkedList list) {
        
    }

    public static void sort(MyLinkedList list) {
        int M = list.size();
        sort(list.first);
    }

    private static void sort(Node lo, Node hi) {
        if (hi == lo) return;
    }

    private static void merge(Node lo, Node mid, Node hi) {
        Node i = lo;
        Node j = mid.next;
        Node current = lo;
        while (i != mid.next && j != hi.next) {
            if (less(j, i)) {
                Node t = j.next;
                j.next = i;
                current.next = j;
                current = j;
                j = t;
            } else if (j == hi.next) {
                current = i;
                i = i.next;
            } else {
                current.next = j;
                current = j;
                j = j.next;
            }
        }
    }

    private static boolean less(Node i, Node j) {
        return i.item < j.item;
    }
}
