import java.util.Collections;
public class QueueMSD
{
    public static void sort(String[] a) {
        int R = 256;
        int N = a.length;
        int d = 0;

        java.util.List<String>[] q = (java.util.LinkedList<String>[]) new java.util.LinkedList[R];
        for (int r = 0; r<R; r++) q[r] = new java.util.LinkedList<String>();

        for (int i = 0; i<N; i++) q[a[i].charAt(d)].add(a[i]);

        for (int r = 0; r<R; r++) Collections.sort(q[r]);

        int i = 0;
        for (int r = 0; r<R; r++) {
            for (String s : q[r]) a[i++] = s;
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAll().split("\\s+");
        sort(a);
        for (String s : a) StdOut.println(s);
    }
}
