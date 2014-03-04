public class FarthestSum
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];

        for (int i = 0; i<N; i++) {
            a[i] = StdIn.readInt();
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int last = Integer.MAX_VALUE;
        int secLast = Integer.MAX_VALUE;

        for (int i = 0; i<N; i++) {
            if (a[i] > first) {
                first = a[i];
            } if (a[i] < first && a[i] > second) {
                second = a[i];
            } if (a[i] < last) {
                last = a[i];
            } if (a[i] > last && a[i] < secLast) {
                secLast = a[i];
            }
        }
        if (first + second > Math.abs(last + secLast)) {
            StdOut.println(first + " " + second);
        } else {
            StdOut.println(last + " " + secLast);
        }
    }
}
