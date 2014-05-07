public class DiscreteDist
{
    public static void disc(double[] a) {
        int N = a.length;
        Merge.sort(a);
        double[] d = new double[N];
        for (int i = 0; i<N; i++) {
            d[i] += a[i];
        }