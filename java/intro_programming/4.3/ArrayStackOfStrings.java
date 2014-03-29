public class ArrayStackOfStrings
{
    private String[] a;
    private int N = 0;

    public ArrayStackOfStrings(int max) {
        a = new String[max];
    }

    public boolean isEmpty() {return N == 0;}

    public void push(String s) {a[N++] = s;}

    public String pop() {
        String item = a[--N];
        a[N] = null;
        return item;
    }

    public boolean isFull() {return N == a.length;}

    public String peek() {return a[N-1];}

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        ArrayStackOfStrings s = new ArrayStackOfStrings(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else {
                StdOut.println(s.pop());
            }
        }
    }
}
