public class SortTester
{
    private static boolean isSorted(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i<N; i++) if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static Double[] makeArray(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i<N; i++) a[i] = StdRandom.uniform();
        return a;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        for (int t = 0; t<T; t++) {
            Double[] a = makeArray(N);
            MyQuickSorter.quick3Way(a);
            assert(isSorted(a));
        }
    }
}
        
