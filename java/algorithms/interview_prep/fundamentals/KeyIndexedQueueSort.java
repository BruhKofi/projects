public class KeyIndexedQueueSort
{
    public static final int R = 256; // EXTENDED_ASCII alphabet

    public static void sort(char[] c) {
        Queue<Character>[] q = (Queue<Character>[]) new Queue[R];
        for (int r = 0; r<R; r++) q[r] = new Queue<Character>();
        int N = c.length;
        for (int i = 0; i<N; i++) q[c[i]].enqueue(c[i]);

        char[] aux = new char[N];
        int i = 0;
        for (int r = 0; r<R; r++) {
            while (!q[r].isEmpty()) aux[i++] = q[r].dequeue();
        }
        for (int k = 0; k<N; k++) c[k] = aux[k];
    }

    private static boolean isSorted(char[] c) {
        for (int i = 1; i<c.length; i++) if (c[i-1] > c[i]) return false;
        return true;
    }

    private static char[] randCharArray(int N) {
        char[] c = new char[N];
        for (int i = 0; i<N; i++) c[i] = (char)StdRandom.uniform(R);
        return c;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        char[] c = randCharArray(N);
        sort(c);
        assert(isSorted(c));
    }
}
