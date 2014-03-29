public class DoublingQueueOfStrings
{
    private String[] a;
    private int first;
    private int last;

    public DoublingQueueOfStrings() {
        a = new String[2];
        first = 0;
        last = 0;
    }
    
    public boolean isEmpty() {
        return first == last;
    }
    
    public void enqueue(String s) {
        if (last == a.length) {
            copy(2*a.length);
        }
        a[last++] = s;
    }

    public String dequeue() {
        if (first > 3*a.length/4) {
            copy(a.length/2);
        }
        String s = a[first++];
        return s;
    }

    public void copy(int size) {
        String[] copy = new String[size];
        int j = 0;
        for (int i = first; i<last; i++) {
            copy[j++] = a[i];
        }
        a = copy;
    }

    public static void main(String[] args) {
        DoublingQueueOfStrings q = new DoublingQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.println(q.dequeue());
            } else {
                q.enqueue(s);
            }
        }
    }
}
