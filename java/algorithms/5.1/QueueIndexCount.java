public class QueueIndexCount
{
    public static void main(String[] args) {
        final int R = 26;
        final int offset = 'a';
        String[] a = StdIn.readAll().split("\\s+");
        int N = a.length;
        Queue<String>[] q = (Queue<String>[]) new Queue[R];
        for (int i = 0; i<R; i++) q[i] = new Queue<String>();
        for (int i = 0; i<N; i++) {
            q[a[i].charAt(0)-offset].enqueue(a[i]);
        }

        String[] aux = new String[N];
        int k = 0;
        for (int i = 0; i<q.length; i++) {
            for (String s : q[i]) aux[k++] = s;
        }

        for (int i = 0; i<N; i++) a[i] = aux[i];

        for (String s : a) StdOut.println(s);
    }
}
