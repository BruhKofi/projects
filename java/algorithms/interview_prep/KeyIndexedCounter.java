/*
  Linear time sort when we know key values are between 0 and R-1
*/

public class KeyIndexedCounter
{
    public static void sort(int[] a, int R) {
        int N = a.length;
        int[] cnt = new int[R+1];
        int[] aux = new int[N];
        for (int i = 0; i<N; i++) cnt[a[i]+1]++;
        for (int i = 0; i<R; i++) cnt[i+1] += cnt[i];
        for (int i = 0; i<N; i++) aux[cnt[a[i]]++] = a[i];
        for (int i = 0; i<N; i++) a[i] = aux[i];
    }

    private static int[] makeArray(int N, int R) {
        int[] a = new int[N];
        for (int i = 0; i<N; i++) a[i] = StdRandom.uniform(R);
        return a;
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i<a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);
        int[] a = makeArray(N, R);
        sort(a, R);
        assert(isSorted(a));
    }
}
