public class MyLinkedList<Item>
{
    private Node first;
    private Node last;
    private Node mid;
    private int N;
    
    private class Node
    {
        Item item;
        Node next;
    }

    public void add(Item item) {
        N++;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (N == 1) {
            last = first;
            mid = first;
        } else if (N%2 == 0) {
            mid = mid.next;
        }
    }

    public int size() {
        return N;
    }

    public static void sort(MyLinkedList list) {
        sort(list, first, last);
    }

    private static void sort(MyLinkedList list, int lo, int hi) {
        if (fist == last) return;
        int mid = lo + (hi - lo)/2;
        sort(list, lo, mid);
        sort(list, mid+1, hi);
        merge(list, lo, mid, hi);
    }

    private static void merge(MyLinkedList list, int lo, int mid, int hi) {
        
    }
}
