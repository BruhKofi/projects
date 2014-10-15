/*
  Elementary linked list implementation with stack API
*/
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item>
{
    private Node first;
    private int N;

    private class Node
    {
        private Item item;
        private Node next;

        public String toString() {
            return item + "";
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item  = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void sort() {
        sort(first, 0, N-1);
    }

    private void sort(Node start, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        Node middle = getNode(start, lo, mid);
        Node end = getNode(middle, mid, hi);
        sort(start, lo, mid);
        sort(middle, mid+1, hi);
        start = merge(start, middle, end);
    }

    private Node merge(Node list1, Node list2, Node end) {
        Node list1End = list2, list2End = end;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Swap pointers if needed to ensure list1 hold the smallest element
        Node head;
        if (list1.item.compareTo(list2.item) < 0) {
            head = list1;
        } else {
            head = list2;
            list2 = list1;
            list1 = head;
            list1End = end;
            list2End = list1;
        }
        
        while(list1.next != list1End && list2 != list2End) {
            if (list1.next.item.compareTo(list2.item) > 0) {
                Node tmp = list1.next;
                list1.next = list2;
                list2 = tmp;
            }
            list1 = list1.next;
        }
        if (list1.next == null) list1.next = list2;
        return head;
    }

    private Node getNode(Node x, int start, int index) {
        for (int i = start; i<index; i++) {
            x = x.next;
        }
        return x;
    }

    private boolean isSorted() {
        return isSorted(first);
    }

    private boolean isSorted(Node x) {
        if (x == null || x.next == null) return true;
        for (Node t = x; t.next != null; t = t.next) {
            if (t.item.compareTo(t.next.item) < 0) return false;
        }
        return true;
    }
        

    public void reverse() {
        first = reverse(first);
    }
    
    private Node reverse(Node x) {
        if (x == null) return null;
        if (x.next == null) return x;
        Node second = x.next;
        Node tail = reverse(second);
        second.next = x;
        x.next = null;
        return tail;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i<N; i++) list.push(i);
        for (Integer i : list) {
            StdOut.println(i);
        }
        StdOut.println();
        list.reverse();
        for (Integer i : list) {
            StdOut.println(i);
        }
        list.reverse();
        list.sort();
        assert(list.isSorted());
        StdOut.println();
        for (Integer i : list) {
            StdOut.println(i);
        }
    }
}
