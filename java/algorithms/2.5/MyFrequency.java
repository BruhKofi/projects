public class MyFrequency
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        String[] a = new String[N];
        for (int i = 0; i<N; i++) {
            a[i] = StdIn.readString();
        }
        Quick.sort(a);
        int i = 1;
        int cnt = 1;
        while (true) {
            while (i < N && a[i-1].compareTo(a[i]) == 0) {
                i++;
                cnt++;
            }
            StdOut.println(a[i-1] + ": " + cnt);
            cnt = 1;
            i++;
            if (i >= N) break;
        }
    }
}
