public class DJIAClient
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        In in = new In(args[1]);
        DJIA[] data = new DJIA[N];
        for (int i = 0; i<N; i++) {
            data[i] = new DJIA(in.readLine());
        }
        Merge.sort(data);
        for (DJIA d : data) {
            StdOut.println(d);
        }
    }
}
