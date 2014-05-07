public class InsertionTrace
{
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i<N; i++) {
            for (int j = i; j>0; j--) {
                if (a[j-1].compareTo(a[j]) > 0) {
                    exch(a, j-1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAll().split("\\s+");
        sort(a);
        for (int i = 0; i<a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}