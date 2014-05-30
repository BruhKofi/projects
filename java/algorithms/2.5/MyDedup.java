public class MyDedup
{
    public static String[] dedup(String[] a) {
        int N = a.length;
        Quick.sort(a);
        int cnt = 1;
        for (int i = 1; i<N; i++) {
            if (a[i-1].compareTo(a[i]) != 0) cnt++;
        }
        String[] b = new String[cnt];
        int j = 0;
        b[j++] = a[0];
        for (int i = 1; i<N; i++) {
            if (!(a[i-1].compareTo(a[i]) == 0)) {
                b[j++] = a[i];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        String[] a = new String[N];
        int i = 0;
        while (!StdIn.isEmpty()) {
            a[i++] = StdIn.readString();
        }
        StdOut.println();
        String[] b = dedup(a);
        for (String s : b) {
            StdOut.println(s);
        }
    }
}
