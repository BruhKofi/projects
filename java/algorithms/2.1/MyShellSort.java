public class MyShellSort
{
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] a = new double[N];
        for (int i = 0; i<N; i++) {
            a[i] = N - i;
        }
        shellSort(a);
        assert(isSorted(a));
    }

    private static boolean isSorted(double[] a) {
        for (int i = 1; i<a.length; i++) {
            if(a[i-1] > a[i]) return false;
        }
        return true;
    }

    public static void shellSort(double[] a) {
        int N = a.length;
        int inc = 1;
        int l = 1;
        while (l < N/3) {
            l = 3*l + 1;
            inc++;
        }
        int[] h = new int[inc];
        h[0] = 1;
        for (int i = 1; i<h.length; i++) {
            h[i] = 3*h[i-1] + 1;
        }
        for (int k = h.length - 1; k>=0; k--) {
            int sz = N - h[k];
            int cmp = 0;
            for (int i = 0; i<N; i++) {
                for (int j = i; j>=h[k] && a[j-h[k]] > a[j]; j -= h[k]) {
                    cmp++;
                    exch(a, j, j-h[k]);
                }
            }
            StdOut.printf("h: %d subarray size: %d compares: %d compares/size: %5.1f\n", h[k], sz, cmp, (double)cmp/sz); 
        }
    }

    public static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
