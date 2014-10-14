public class STSort
{
    public static void sort(Comparable[] o) {
        int N = o.length;
        LinearProbingHashST<Comparable, Integer> st = new LinearProbingHashST<Comparable, Integer>();
        for (int i = 0; i<N; i++) {
            if (st.contains(o[i])) st.put(o[i], st.get(o[i]) + 1);
            else st.put(o[i], 1);
        }
        Comparable[] aux = new Comparable[N];
        int index = 0;
        for (Comparable c : st.keys()) {
            int cnt = st.get(c);
            int i = 0;
            for (i = 0; i<cnt; i++) {
                aux[i+index] = c;
            }
            index = index + i;
        }
        for (int i = 0; i<N; i++) {
            o[i] = aux[i];
        }
    }

    private static Integer[] makeIntArray(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i<N; i++) a[i] = StdRandom.uniform(N);
        return a;
    }

    private static boolean isSorted(Integer[] a) {
        for (int i = 1; i<a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Integer[] a = makeIntArray(N);
        sort(a);
        assert(isSorted(a));
    }
}
