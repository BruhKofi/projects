public class FixedCapacityStackOfInts
{
    private int[] a;
    private int N;

    public FixedCapacityStackOfInts(int size) {
        a = new int[size];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(int i) {
        a[N++] = i;
    }

    public int pop() {
        return a[--N];
    }
}
        