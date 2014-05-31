import java.util.Arrays;
public class SearchTester
{
    public static int bs(double[] a, double key) {
        int lo = 0;
        int hi = a.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (key < a[mid]) hi = mid-1;
            else if (key > a[mid]) lo = mid+1;
            else return mid;
        }
        return -1;
    }

    public static int is(double[] a, double key) {
        int lo = 0;
        int hi = a.length-1;
        int mid = (int) ((key - a[lo])/(a[hi] - a[lo])*a.length);
        while (lo <= hi) {
            if (key < a[mid]) hi = mid-1;
            else if (key > a[mid]) lo = mid+1;
            else return mid;
            mid = lo + (hi - lo)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        double bsTime = 0.0;
        double isTime = 0.0;
        for (int t = 0; t<T; t++) {
            double[] a = new double[N];
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform();
            }
            double k = a[0];
            Arrays.sort(a);
            Stopwatch sw = new Stopwatch();
            int j = bs(a, k);
            bsTime += sw.elapsedTime();
            for (int i = 0; i<N; i++) {
                a[i] = StdRandom.uniform();
            }
            k = a[0];
            Arrays.sort(a);
            sw = new Stopwatch();
            j = is(a, k);
            isTime += sw.elapsedTime();
        }
        StdOut.println("Average time to find key using binary search: " + bsTime/(double)T);
        StdOut.println("Average time to find key using interpolation search: " + isTime/(double)T);
    }        
}
