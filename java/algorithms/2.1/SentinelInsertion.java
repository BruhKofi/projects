public class SentinelInsertion
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdRandom.uniform();
        }
        sort(a);
        assert(isSorted(a));
    }

    private static boolean isSorted(double[] a) {
        for (int i = 1; i<a.length; i++) {
            if(a[i-1] > a[i]) return false;
        }
        return true;
    }

    public static void sort(double[] a) {
        int N = a.length;
        int min = 0;
        for (int i = 0; i<N; i++) {
            if (a[i] < a[min]) min = i;
            exch(a, 0, min);
        }

        for (int i = 1; i<N; i++) {
            for (int j = i; a[j-1] > a[j]; j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int min = 0;
        for (int i = 0; i<N; i++) {
            if (a[i].compareTo(a[min]) < 0) min = i;
            exch(a, 0, min);
        }

        for (int i = 1; i<N; i++) {
            for (int j = i; a[j-1].compareTo(a[j]) > 0; j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
