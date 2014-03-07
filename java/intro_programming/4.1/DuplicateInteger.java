public class DuplicateInteger
{
    public static int duplicate(int[] a) {
        int N = a.length;
        boolean[] b = new boolean[N];

        for (int i = 0; i<N; i++) {
            b[a[i]] = true;
        }

        for (int i = 0; i<N; i++) {
            if (!b[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 4;
        for (int i = N; true; i *= 2) {
            int[] a = new int[i];
            int k = StdRandom.uniform(i);
            for (int j = 0; j < i; j++) {
                a[j] = j;
            }
            a[k] = k > 1 ? a[k-1] : a[k+1];
            Stopwatch sw = new Stopwatch();
            int d = duplicate(a);
            StdOut.println(i + "\t\t" + sw.elapsedTime());
        }
    }
}