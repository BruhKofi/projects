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

    public static void sort(MyLinkedList list) {

        
    }

    private static void merge(Node lo, Node mid, Node hi) {
        Node i = lo;
        Node j = mid.next;
        for (Node x = lo; x != hi; x = x.next) {
            
        }
    }
}
